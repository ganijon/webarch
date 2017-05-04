package edu.mum.waa;

import java.util.List;

public class BBHttpRequest {
	private String method;
	private String uri;
	private String httpVersion;
	private List<String> fields;
	private List<String> message;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getHttpVersion() {
		return httpVersion;
	}
	public void setHttpVersion(String version) {
		this.httpVersion = version;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> messge) {
		this.message = messge;
	}
	public String getStartLine(){
		return method+" "+uri+" "+httpVersion+"\r\n";
	}
}
