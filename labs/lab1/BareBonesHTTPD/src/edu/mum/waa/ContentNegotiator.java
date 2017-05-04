package edu.mum.waa;

public interface ContentNegotiator {
	public static final String DOC_ROOT = "//home//john//docroot/";
	public void negotiate(BBHttpRequest httpRequest, BBHttpResponse httpResponse) ;
}
