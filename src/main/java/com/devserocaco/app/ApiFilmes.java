package com.devserocaco.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiFilmes {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Busca informações do config.properties
				String apiKey = "";
				Properties keys = new Properties();
				try {
					FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
					keys.load(fileInputStream);
					apiKey = keys.getProperty("apiKey");
				}	catch (IOException e) {
		            e.printStackTrace();
		        }
				
				URI tmdbAPI = URI.create("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=pt-br-US&page=1&sort_by=vote_average.desc&without_genres=99,10755&vote_count.gte=200");
				
				//Realiza a chamada para a API
				HttpClient client = HttpClient.newHttpClient();
			
				HttpRequest request = HttpRequest.newBuilder(tmdbAPI).header("accept", "application/json")
					  .header("Authorization", "Bearer " + apiKey)
					  .build();
			
				HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
				
				
				String jsonFilmes = response.body();
				System.out.println(jsonFilmes);
				
				//Perseando o json com jackson
				
				ObjectMapper objectMapper = new ObjectMapper();
				
				JsonNode jsonNode = objectMapper.readTree(jsonFilmes);
				
				JsonNode ArrayFilmes = jsonNode.get("results");
				for (JsonNode lista : ArrayFilmes) {
					System.out.println(lista.get("original_title"));
				}
	}

}
