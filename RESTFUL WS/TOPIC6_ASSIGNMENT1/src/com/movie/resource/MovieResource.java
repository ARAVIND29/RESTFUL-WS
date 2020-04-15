package com.movie.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;

import com.movie.dao.MovieDao;
import com.movie.model.Movie;

@Path("/movies")
public class MovieResource {
	
	MovieDao data = new MovieDao();
	
	@GET
	@Path("/all")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Movie> getAllMovies()
	{
		return data.getMovies();
	}
	
	
	
	@GET
	@Path("{id}")
	@Produces({MediaType.TEXT_XML,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Movie getMovieById(@PathParam("id") String id) {
		
		return data.getMovieById(id);
	}
	
}
