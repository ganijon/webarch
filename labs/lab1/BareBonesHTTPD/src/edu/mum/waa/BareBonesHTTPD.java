package edu.mum.waa;

import java.io.*;
import java.net.*;
import java.util.*;

public class BareBonesHTTPD extends Thread {

	private static final int PortNumber = 8080;

	private ContentNegotiator contentNegotiator = null;
	private Socket connectedClient = null;

	public BareBonesHTTPD(Socket client) {
		connectedClient = client;
		contentNegotiator = new MainContentNegotiator();
	}

	public void run() {

		try {
			System.out.println(connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " is connected");

			BBHttpRequest httpRequest = getRequest(connectedClient.getInputStream());
			BBHttpResponse httpResponse = new BBHttpResponse();

			processRequest(httpRequest, httpResponse);

			sendResponse(httpResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private BBHttpRequest getRequest(InputStream inputStream) throws IOException {

		BBHttpRequest httpRequest = new BBHttpRequest();

		BufferedReader fromClient = new BufferedReader(new InputStreamReader(inputStream));

		String requestString = fromClient.readLine();
		String headerLine = requestString;

		System.out.println("The HTTP request is ....");
		System.out.println(requestString);

		// Header Line
		StringTokenizer tokenizer = new StringTokenizer(headerLine);
		httpRequest.setMethod(tokenizer.nextToken());
		httpRequest.setUri(tokenizer.nextToken());
		httpRequest.setHttpVersion(tokenizer.nextToken());

		// Header Fields and Body
		boolean readingBody = false;
		List<String> fields = new ArrayList<>();
		List<String> body = new ArrayList<>();

		while (fromClient.ready()) {

			requestString = fromClient.readLine();
			System.out.println(requestString);

			if (!requestString.isEmpty()) {
				if (readingBody) {
					body.add(requestString);
				} else {
					fields.add(requestString);
				}
			} else {
				readingBody = true;
			}
		}
		httpRequest.setFields(fields);
		httpRequest.setMessage(body);
		return httpRequest;
	}

	private void processRequest(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {

		contentNegotiator.negotiate(httpRequest, httpResponse);
	}

	private void sendResponse(BBHttpResponse response) throws IOException {

		String statusLine = null;

		switch (response.getStatusCode()) {
			case 200:
				statusLine = "HTTP/1.1 200 OK" + "\r\n";
				break;
			case 400:
				statusLine = "HTTP/1.1 400 Bad Request" + "\r\n";
				break;
			case 404:
				statusLine = "HTTP/1.1 404 Not Found" + "\r\n";
				break;
			case 500:
				statusLine = "HTTP/1.1 500 Internal server error" + "\r\n";
				break;
			case 501:
				statusLine = "HTTP/1.1 501 Not Implemented" + "\r\n";
				break;
		}

		String serverdetails = "Server: BareBones HTTPServer";
		String contentLengthLine = "Content-Length: " + response.getMessage().length() + "\r\n";
		String contentTypeLine = "Content-Type: " + response.getContentType() + "\r\n";

		DataOutputStream toClient = new DataOutputStream(connectedClient.getOutputStream());

		toClient.writeBytes(statusLine);
		toClient.writeBytes(serverdetails);
		toClient.writeBytes(contentTypeLine);
		toClient.writeBytes(contentLengthLine);
		toClient.writeBytes("Connection: close\r\n");
		toClient.writeBytes("\r\n");
		toClient.writeBytes(response.getMessage());

		toClient.close();
	}

	public static void main(String args[]) throws Exception {

		ServerSocket Server = new ServerSocket(PortNumber, 10, InetAddress.getByName("127.0.0.1"));
		System.out.println("Server Started on port " + PortNumber);

		while (true) {
			Socket connected = Server.accept();
			(new BareBonesHTTPD(connected)).start();
		}
	}
}
