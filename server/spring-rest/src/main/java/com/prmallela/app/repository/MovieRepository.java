package com.prmallela.app.repository;


import com.prmallela.app.entity.Movie;

import java.util.List;

public interface MovieRepository {

    public List<Movie> findAll();

    public Movie findOne(String mid);

    public Movie findByTitle(String title);

    public List<Movie> findByYear(int year);

    public Movie findByImdbId(String imdbId);

    public Movie create(Movie mov);

    public Movie update(Movie mov);

    public void delete(Movie mov);
}
