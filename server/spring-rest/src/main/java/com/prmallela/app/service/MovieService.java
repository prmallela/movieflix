package com.prmallela.app.service;

import com.prmallela.app.entity.Movie;

import java.util.List;


public interface MovieService {
	
	public List<Movie> findAll();

	public Movie findOne(String mid);

	public Movie findByTitle(String title);

	public List<Movie> findByYear(int year);

	public Movie findByImdbId(String imdbId);

	public Movie create(Movie mov);

	public Movie update(String mid, Movie movie);

	public void remove(String mid);


}
