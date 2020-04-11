package com.trendnxt.topic6.assignment1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private String movieId;
	private String movieName;
	private String movieActor;
	private Float movieCollection;
	
	public Movie(String movieId, String movieName, String movieActor, Float movieCollection) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieActor = movieActor;
		this.movieCollection = movieCollection;
	}
	
	public Movie() {
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	public Float getMovieCollection() {
		return movieCollection;
	}
	public void setMovieCollection(Float movieCollection) {
		this.movieCollection = movieCollection;
	}
}
