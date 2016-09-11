package com.prmallela.app.repository;


import com.prmallela.app.entity.Movie;
import com.prmallela.app.entity.RatingComment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RatingCommentRepositoryImp implements RatingCommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RatingComment update(RatingComment ratingComment) {
        return em.merge(ratingComment);
    }

    @Override
    public void delete(RatingComment ratingComment) {
        em.remove(ratingComment);

    }

    @Override
    public RatingComment findOne(String rcid) {
        return em.find(RatingComment.class,rcid);
    }
}
