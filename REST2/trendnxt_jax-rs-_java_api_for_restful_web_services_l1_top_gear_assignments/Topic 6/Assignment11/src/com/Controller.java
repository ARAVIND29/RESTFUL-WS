package com;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	
	List<Movie> movieArr=new ArrayList<>();
	
	public void addMovies() {
		List<String> movies=new ArrayList<>();
		movies.add("Shutter Island");
		movies.add("Iron Man");
		movies.add("Captain America");
		movies.add("Captain Marvel");
		movies.add("Batman");
		movies.add("World War Z");
		movies.add("Thor");
		movies.add("Suicide Squad");
		movies.add("Martian");
		movies.add("Green Lantern");
		
		List<String> actors=new ArrayList<>();
		actors.add("Lionardo De Carpio");
		actors.add("Robert Downey");
		actors.add("Chris Evans");
		actors.add("Brie Larson");
		actors.add("Ben Aflleck");
		actors.add("Brad Pitt");
		actors.add("Chris Hemsworth");
		actors.add("Margot Robbie");
		actors.add("Matt Damon");
		actors.add("Ryan Raynolds");
		
		for(int i=1;i<11;i++) {
			Movie m=new Movie();
			m.setMovieId("m00"+i);
			m.setMovieName(movies.get(i-1));
			m.setMovieActor(actors.get(i-1));
			m.setMovieCollection((float) (i*201051541.54));
			movieArr.add(m);
		}
	}
	
	public List<Movie> getMovies(){
		addMovies();
		return this.movieArr;
	}
	
	public Movie getMovieById(String id) {
		Movie m=new Movie();
		addMovies();
		try {
		for(Movie m1:movieArr) {
			if(id.equalsIgnoreCase(m1.getMovieId())) {
				return m1;
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
}
