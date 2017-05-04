package edu.mum.waa;

import java.net.URI;
import java.net.URISyntaxException;


public class MainContentNegotiator implements ContentNegotiator {


	@Override
	public void negotiate(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		
		try {

			String filePath = new URI(httpRequest.getUri()).getPath();
		
			switch (filePath) {
				case "/welcome.web":
					new WelcomeContentNegotiator().negotiate(httpRequest, httpResponse);
					break;
				case "/contacts.web":
					new ContactsContentNegotiator().negotiate(httpRequest, httpResponse);
					break;
				default:
					new FileContentNegotiator().negotiate(httpRequest, httpResponse);
					break;		
			}
			

		} catch (URISyntaxException e) {
			httpResponse.setMessage("Bad Request");
			httpResponse.setStatusCode(400);
			e.printStackTrace();
			return;
		}
		
		
	}
}
