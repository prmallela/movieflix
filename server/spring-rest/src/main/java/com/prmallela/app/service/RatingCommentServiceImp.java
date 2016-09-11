package com.prmallela.app.service;


import com.prmallela.app.entity.Movie;
import com.prmallela.app.entity.RatingComment;
import com.prmallela.app.entity.User;
import com.prmallela.app.repository.MovieRepository;
import com.prmallela.app.repository.RatingCommentRepository;
import com.prmallela.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RatingCommentServiceImp implements RatingCommentService {

    @Autowired
    private RatingCommentRepository ratingCommentRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<RatingComment> findAll(String mid) {
        Movie movie = movieRepository.findOne(mid);
        if (movie ==null){
            throw new EntityNotFoundException("Movie not Found");
        }
            return movie.getRatingComments();
    }

    @Transactional
    @Override
    public RatingComment create(String mid, String uid, RatingComment ratingComment) {
       User user = userRepository.findOne(uid);
        Movie movie = movieRepository.findOne(mid);
        if(movie == null){
            throw new EntityNotFoundException("Movie not Found");
        }else if(user ==null){
            throw  new EntityNotFoundException("Unknow User");
        }
        ratingComment.setUser(user);
        movie.setRatingComments(ratingComment);
        movieRepository.update(movie);
        return ratingComment;
    }

    @Transactional
    @Override
    public RatingComment update(String rcid, RatingComment ratingComment) {
        return ratingCommentRepository.update(ratingComment);

    }
    @Transactional
    @Override
    public void remove(String rcid) {
        RatingComment ratingComment = ratingCommentRepository.findOne(rcid);
        if(ratingComment ==null){
            throw new EntityNotFoundException("RatingComment Not Found");
        }
        ratingCommentRepository.delete(ratingComment);

    }
}
