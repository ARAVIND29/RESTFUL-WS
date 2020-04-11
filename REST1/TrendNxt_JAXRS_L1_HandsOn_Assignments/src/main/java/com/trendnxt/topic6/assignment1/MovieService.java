package com.trendnxt.topic6.assignment1;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class MovieService {
	
	private List<Movie> movies = Arrays.asList(
			new Movie("M001", "Top Gun", "Tom Cruise", 350000000.00f),
			new Movie("M002", "Avatar", " Sam Worthington, Zoe Saldana, Sigourney Weaver, Michelle Rodriguez", 950000000.00f),
			new Movie("M003", "Titanic", "Leonardo DiCaprio, Kate Winslet, Billy Zane, Kathy Bates", 940000000.00f),
			new Movie("M004", "Star Wars: Episode VII - The Force Awakens", "Daisy Ridley, John Boyega, Oscar Isaac, Domhnall Gleeson", 840000000.00f),
			new Movie("M005", "Jurassic World", "Chris Pratt, Bryce Dallas Howard, Ty Simpkins, Judy Greer", 830000000.00f),
			new Movie("M006", "The Avengers", "Robert Downey Jr., Chris Evans, Scarlett Johansson, Jeremy Renner", 830000000.00f),
			new Movie("M007", "Furious 7", "Vin Diesel, Paul Walker, Dwayne Johnson, Jason Statham", 730000000.00f),
			new Movie("M008", "Avengers: Age of Ultron", "Robert Downey Jr., Chris Evans, Mark Ruffalo, Chris Hemsworth", 720000000.00f),
			new Movie("M009", "Harry Potter and the Deathly Hallows: Part 2", "Daniel Radcliffe, Emma Watson, Rupert Grint, Michael Gambon", 610000000.00f),
			new Movie("M010", "Frozen", "Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad", 590000000.00f),
			new Movie("M011", "Iron Man 3", "Robert Downey Jr., Guy Pearce, Gwyneth Paltrow, Don Cheadle", 490000000.00f)
			) ;
	
	@GET
	@Path("/movies")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Movie> getMovieTextXML() {
		return movies;
	}
	
	@GET
	@Path("/movie/{movieId}")
	@Produces(MediaType.APPLICATION_XML)
	public Movie getMovieApplicationXML(@PathParam("movieId") String movieId) {
		for(Movie movie : movies) {
			if(movieId.equalsIgnoreCase(movie.getMovieId())) {
				return movie;
			}
		}
		return null;
	}
}