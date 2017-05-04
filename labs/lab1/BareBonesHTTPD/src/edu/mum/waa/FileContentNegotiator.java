package edu.mum.waa;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class FileContentNegotiator implements ContentNegotiator {

	@Override
	public void negotiate(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		
		try {
			String filePath = new URI(httpRequest.getUri()).getPath();
			String fileExtension = resolveFileExtension(filePath.toLowerCase());
			
			switch(fileExtension) {
				case "":
				case "txt":
				case "html":
					resolveTxtHtmlContent(httpRequest, httpResponse, fileExtension);
					break;
				case "png":
				case "jpg":
				case "tiff":
				case "bmp":
					resolveMediaContent(httpRequest, httpResponse, fileExtension);
					break;
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
	}

	private void resolveMediaContent(BBHttpRequest httpRequest, BBHttpResponse httpResponse, String fileExtension) {
		//TODO: Change BBHttpResponse and expose OutputStream to other classes
		
		// DataOutputStream toClient = new DataOutputStream(connectedClient.getOutputStream());
		
		// I need to 
		//OutputStream outputStream = httpResponse.getOutputStream();

		//outputStream.write(...);
		
	}

	private void resolveTxtHtmlContent(BBHttpRequest httpRequest, BBHttpResponse httpResponse, String fileExtension) {
	
		try {

			File file = new File(DOC_ROOT + httpRequest.getUri());
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\Z");		
			
			httpResponse.setMessage(scanner.next());
			httpResponse.setStatusCode(200);
			httpResponse.setContentType("text/html");
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			
			httpResponse.setMessage("Resource not found");
			httpResponse.setStatusCode(404);
		} 

	}

	private String resolveFileExtension(String filePath) {
		
		int beginIndex = 1 + filePath.lastIndexOf('/');
		int endIndex = filePath.length();
		
		String fileName = filePath.substring(beginIndex, endIndex);
		beginIndex = 1 + fileName.lastIndexOf(".");
		endIndex = fileName.length();
		return (beginIndex == -1)? "": fileName.substring(beginIndex, endIndex); 
	}

}
