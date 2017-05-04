package edu.mum.waa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactsContentNegotiator implements ContentNegotiator {

	@Override
	public void negotiate(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {

		try {
			File file = new File(DOC_ROOT + httpRequest.getUri());
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\Z");

			String response = resolveServerBlocks(scanner.next());

			httpResponse.setMessage(response);
			httpResponse.setContentType("text/html");
			httpResponse.setStatusCode(200);
			scanner.close();

		} catch (FileNotFoundException e) {

			httpResponse.setMessage("Resource not found");
			httpResponse.setStatusCode(404);
		}
	}

	private String resolveServerBlocks(String template) {
		return template.replace("@{Class Name}", this.getClass().getSimpleName())
				.replace("@{Some generated text}", this.getClass().getTypeName().toString());
	}

}
