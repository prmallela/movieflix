package com.prmallela.app.repository;


import com.prmallela.app.entity.RatingComment;

import java.util.List;

public interface RatingCommentRepository {

    public RatingComment update(RatingComment ratingComment);

    public void delete(RatingComment ratingComment);

    public RatingComment findOne(String rcid);
}
