package com.devserocaco.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

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
				
				
				List<Movie> movies = new ArrayList<Movie>();
				
				JsonNode ArrayFilmes = jsonNode.get("results");
				for (JsonNode lista : ArrayFilmes) {
					ArrayNode genreIdsNode = (ArrayNode) lista.get("genre_ids");
				    int[] genreIds = new int[genreIdsNode.size()];
				    for (int i = 0; i < genreIdsNode.size(); i++) {
				        genreIds[i] = genreIdsNode.get(i).asInt();
				    }

				    Movie movie = new Movie(
				        lista.get("adult").asBoolean(),
				        lista.get("backdrop_path").asText(),
				        genreIds,
				        lista.get("id").asInt(),
				        lista.get("original_language").asText(),
				        lista.get("original_title").asText(),
				        lista.get("overview").asText(),
				        lista.get("popularity").asDouble(),
				        lista.get("poster_path").asText(),
				        lista.get("release_date").asText(),
				        lista.get("title").asText(),
				        lista.get("video").asBoolean(),
				        lista.get("vote_average").asDouble(),
				        lista.get("vote_count").asInt()
				    );
				    System.out.println(movie);
				    movies.add(movie);
				}
				
				
				//Gerando o HTML
				
				try {
					System.out.println(movies.get(0).getGenre_ids()[1]);
					
					PrintWriter writer = new PrintWriter("filmes.html");
					
					HTMLGenerator gerador = new HTMLGenerator(writer, movies);
					gerador.generate();
					
					writer.close();	
					System.out.println("HTML GERADO COM SUCESSO");
				} catch (IOException e) {
					System.out.println("Ocorreu um erro ao gerar o HTML:" + e);
				}
	}

}
