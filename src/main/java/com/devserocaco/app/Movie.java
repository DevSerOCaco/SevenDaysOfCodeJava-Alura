package com.devserocaco.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Movie {
	
	private Boolean adult;
	private String backdrop_path;
	private List<String> genre_ids = new ArrayList<>();
	private Integer id;
	private String original_languege;
	private String original_title;
	private String overiew;
	private double popularity;
	private String poster_path;
	private LocalDate release_date;
	private String title;
	private Boolean video;
	private double vote_avarage;
	private Integer vot_count;
	
	
	
	
	 public Movie(Boolean adult, String backdrop_path, List<String> genre_ids, int id, String original_languege,
			String original_title, String overiew, double popularity, String poster_path, String release_date,
			String title, Boolean video, double vote_avarage, int vot_count) {
		super();
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.genre_ids = genre_ids;
		this.id = id;
		this.original_languege = original_languege;
		this.original_title = original_title;
		this.overiew = overiew;
		this.popularity = popularity;
		this.poster_path = poster_path;
		setReleaseDate(release_date);
		this.title = title;
		this.video = video;
		this.vote_avarage = vote_avarage;
		this.vot_count = vot_count;
	}


	public void setReleaseDate(String releaseDate) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        this.release_date = LocalDate.parse(releaseDate, formatter);
	        }


	public Boolean getAdult() {
		return adult;
	}


	public void setAdult(Boolean adult) {
		this.adult = adult;
	}


	public String getBackdrop_path() {
		return backdrop_path;
	}


	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOriginal_languege() {
		return original_languege;
	}


	public void setOriginal_languege(String original_languege) {
		this.original_languege = original_languege;
	}


	public String getOriginal_title() {
		return original_title;
	}


	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}


	public String getOveriew() {
		return overiew;
	}


	public void setOveriew(String overiew) {
		this.overiew = overiew;
	}


	


	public void setPopularity(Float popularity) {
		this.popularity = popularity;
	}


	public String getPoster_path() {
		return poster_path;
	}


	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}


	public LocalDate getRelease_date() {
		return release_date;
	}


	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Boolean getVideo() {
		return video;
	}


	public void setVideo(Boolean video) {
		this.video = video;
	}


	


	public List<String> getGenre_ids() {
		return genre_ids;
	}


	public void setGenre_ids(List<String> genre_ids) {
		this.genre_ids = genre_ids;
	}


	public double getPopularity() {
		return popularity;
	}


	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}


	public double getVote_avarage() {
		return vote_avarage;
	}


	public void setVote_avarage(double vote_avarage) {
		this.vote_avarage = vote_avarage;
	}


	public void setVote_avarage(Float vote_avarage) {
		this.vote_avarage = vote_avarage;
	}


	public Integer getVot_count() {
		return vot_count;
	}


	public void setVot_count(Integer vot_count) {
		this.vot_count = vot_count;
	}


	@Override
	public String toString() {
		return "Movie [adult=" + adult + ", backdrop_path=" + backdrop_path + ", genre_ids=" + genre_ids + ", id=" + id
				+ ", original_languege=" + original_languege + ", original_title=" + original_title + ", overiew="
				+ overiew + ", popularity=" + popularity + ", poster_path=" + poster_path + ", release_date="
				+ release_date + ", title=" + title + ", video=" + video + ", vote_avarage=" + vote_avarage
				+ ", vot_count=" + vot_count + "]";
	}
	
	
}
