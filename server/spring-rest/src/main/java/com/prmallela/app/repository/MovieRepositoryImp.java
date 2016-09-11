package com.prmallela.app.repository;


import com.prmallela.app.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MovieRepositoryImp implements MovieRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> findAll() {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll",Movie.class);
        return query.getResultList();
    }

    @Override
    public Movie findOne(String mid) {
        return em.find(Movie.class,mid);
    }

    @Override
    public Movie findByTitle(String title) {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
        query.setParameter("ptitle", title);
        List<Movie> movies = query.getResultList();
        if (movies.size() == 1) {
            return movies.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Movie> findByYear(int year) {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
        query.setParameter("ptitle", year);
        List<Movie> movies = query.getResultList();
        if (movies == null){
            return null;
        }
        return movies;
    }

    @Override
    public Movie findByImdbId(String imdbId) {
        TypedQuery<Movie> query = em.createNamedQuery("Movie.findByImdbId", Movie.class);
        query.setParameter("pimdbid", imdbId);
        Movie movie = query.getSingleResult();
        if (movie == null){
            return null;
        }
        return movie;
    }

    @Override
    public Movie create(Movie mov) {
        em.persist(mov);
        return mov;
    }

    @Override
    public Movie update(Movie mov) {
        return em.merge(mov);
    }

    @Override
    public void delete(Movie mov) {
        em.remove(mov);

    }
}
