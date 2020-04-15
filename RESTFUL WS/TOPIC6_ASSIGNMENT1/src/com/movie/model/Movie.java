package com.movie.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"movieid","movieName","movieActor","movieCollection"})
public class Movie {

	public String movieID;
	public String movieName;
	public String movieActor;
	public float movieCollection;
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
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
	public float getMovieCollection() {
		return movieCollection;
	}
	public void setMovieCollection(float movieCollection) {
		this.movieCollection = movieCollection;
	}
	
	

}
