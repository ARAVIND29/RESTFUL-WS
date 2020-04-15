package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import com.movie.model.Movie;

public class MovieDao {

	public List<Movie> movies = new ArrayList<Movie>();
	
	public MovieDao()
	{
		List<String> mname = new ArrayList<String>();
		mname.add("Sye Raa Narasimha Reddy");
		mname.add("Sarilerunekevaru");
		mname.add("Jalsa");
		mname.add("RRR");
		mname.add("Puspha");
		mname.add("Manmadhdu");
		mname.add("Bahubali");
		mname.add("Bhadra");
		mname.add("F2");
		mname.add("Jersey");
		
		List<String> mactor = new ArrayList<String>();
		mactor.add("Chiranjeevi");
		mactor.add("Mahesh Babu");
		mactor.add("Pawan Kalyan");
		mactor.add("JrNTR");
		mactor.add("Allu Arjun");
		mactor.add("Nagarjuna");
		mactor.add("Prabhas");
		mactor.add("Ravi Teja");
		mactor.add("Venkatesh");
		mactor.add("Nani");
		
		for(int i=1;i<11;i++)
		{
			Movie m=new Movie();
			m.setMovieID("M"+i);
			m.setMovieName(mname.get(i-1));
			m.setMovieActor(mactor.get(i-1));
			m.setMovieCollection((float)i*100000);
			movies.add(m);
		}
		
	}
	
	public List<Movie> getMovies()
	{
		return this.movies;
	}
	
	public Movie getMovieById(String id)
	{
		for(Movie mv : movies)
			{
				if(id.equalsIgnoreCase(mv.getMovieID()))
				{
					return mv;
				}
			}
		return null;
	}
}
