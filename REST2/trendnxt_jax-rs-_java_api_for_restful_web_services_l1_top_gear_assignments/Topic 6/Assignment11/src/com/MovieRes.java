package com;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("movie")
public class MovieRes {
	
	@GET
	@Path("all")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Movie> getAllMovies(){
		Controller c=new Controller();
		return c.getMovies();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovieById(@PathParam("id") String s) {
		Controller c=new Controller();
		return c.getMovieById(s);
	}
}
