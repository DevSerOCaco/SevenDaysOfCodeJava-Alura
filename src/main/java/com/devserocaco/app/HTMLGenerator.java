package com.devserocaco.app;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {

	private PrintWriter writer;
	private List<Movie> movies;

	public HTMLGenerator(Writer writer, List<Movie> movies) {
		super();
		this.writer = (PrintWriter) writer;
		this.movies = movies;
	}
	
	
	public void generate() {
		
		this.writer.println("""
				<!DOCTYPE html>
				<html lang="pt-br">
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
					"integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin=\"anonymous\">					
				</head>
				""");
		this.writer.println("<body class=\"bg-dark\">");
		
		for(Movie movie: movies) {
			this.writer.printf("""
				<div class=\"p-3 mb-2 d-flex justify-content-center \">
					<div class=\"card border border-1 bg-light\" style=\"width: 35rem;\">
						<img class=\"card-img-top\" src=\"https://image.tmdb.org/t/p/w500%s" alt=\"Card image cap\">
						<div class=\"card-body bg-light\">
							  <h5 class=\"card-title\">%s</h5>
							  <p class=\"card-text\">%s</p>	  
						</div>
						<ul class=\"list-group bg-light list-group-flush\">
							<li class=\"list-group-item\"><b>Data de lançamento: </b>%s</li>
							<li class=\"list-group-item\"><b>Nota: </b>%s</li>
					
						</ul>
					</div>
				</div>
					\n""",
					movie.getPoster_path(),
					movie.getTitle(),
					movie.getOveriew(),
					movie.getRelease_date(),
					movie.getVote_avarage());
		}
		
		this.writer.println("</body>");
	}
	
}
