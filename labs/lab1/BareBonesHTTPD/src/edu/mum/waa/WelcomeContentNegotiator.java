package edu.mum.waa;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.EnumSet;
import java.util.Scanner;

public class WelcomeContentNegotiator implements ContentNegotiator {

	@Override
	public void negotiate(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		
		try {
			

			
			File file = new File(DOC_ROOT + httpRequest.getUri());
			
			//Files.setPosixFilePermisions(file.getAbsolutePath(), 
			//	    EnumSet.of(OWNER_READ, OWNER_WRITE, OWNER_EXECUTE, GROUP_READ, GROUP_EXECUTE));
			
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\Z");	
			
			String response = resolveServerBlocks(scanner.next());
			
			httpResponse.setMessage(response);
			httpResponse.setContentType("text/html");
			httpResponse.setStatusCode(200);
			scanner.close();
			return;
			
		} catch (Exception e) {
			
			httpResponse.setMessage("Resource not found");
			httpResponse.setStatusCode(404);
			return;
		} 
	}

	private String resolveServerBlocks(String template) {
		return template.replace("@{Class Name}", this.getClass().getSimpleName())
				.replace("@{Some generated text}", this.getClass().getTypeName().toString());
	}

}
