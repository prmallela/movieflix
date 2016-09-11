package com.prmallela.app.service;


import com.prmallela.app.entity.Movie;
import com.prmallela.app.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService{

    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie findOne(String mid) {
        Movie movie = repository.findOne(mid);
        if(movie==null){
            throw new EntityNotFoundException("Movie not found");
        }
        return movie;
    }

    @Override
    public Movie findByTitle(String title) {
        Movie movie = repository.findByTitle(title);
        if(movie ==null){
            throw new EntityNotFoundException("Movie not found");
        }
        return movie;
    }

    @Override
    public List<Movie> findByYear(int year) {
        List<Movie> movies = repository.findByYear(year);
        if (movies ==null){
            throw new EntityNotFoundException("No Movie or Movies found");
        }
        return movies;
    }

    @Override
    public Movie findByImdbId(String imdbId) {
        Movie movie = repository.findByImdbId(imdbId);
        if(movie ==null){
            throw new EntityNotFoundException("No Movie found");
        }
        return movie;
    }

    @Transactional
    @Override
    public Movie create(Movie mov) {
        Movie movie = repository.findByTitle(mov.getMid());
        if(movie != null){
            throw new EntityExistsException("Movie already exists");
        }
        return repository.create(mov);
    }

    @Transactional
    @Override
    public Movie update(String mid, Movie movie) {
        Movie mov = repository.findOne(mid);
        if(movie==null){
            throw new EntityNotFoundException("Movie not found");
        }
        return repository.update(movie);
    }

    @Transactional
    @Override
    public void remove(String mid) {

        Movie movie=repository.findOne(mid);
        if (movie == null){
            throw new EntityNotFoundException("Movie not found");
        }
        repository.delete(movie);

    }


}
