package com.devserocaco.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TmdbApiClient {

	private URI uri;
	private PropertiesFile pf; 
	private HttpClient client;
	HttpRequest request;
	HttpResponse<String> response;
	
	public TmdbApiClient(URI uri) throws IOException, InterruptedException {
		super();
		this.uri = uri;
		this.pf = new PropertiesFile();
		this.client = HttpClient.newHttpClient();
		this.request = setRequest();
		this.response = setResponse();
		
	}
	
	private HttpRequest setRequest() {
		return HttpRequest.newBuilder(uri).header("accept", "application/json")
				  .header("Authorization", "Bearer " + pf.getApiKey())
				  .build();
	}
	
	private HttpResponse<String> setResponse() throws IOException, InterruptedException{
		return client.send(request, HttpResponse.BodyHandlers.ofString());
	}
	
	public String getJsonBody() {
		return response.body();
	}
	
}
