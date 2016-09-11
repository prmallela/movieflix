package com.prmallela.app.service;


import com.prmallela.app.entity.RatingComment;

import java.util.List;

public interface RatingCommentService {

    public List<RatingComment> findAll(String mid);

    public RatingComment create(String mid,String uid, RatingComment ratingComment);

    public RatingComment update(String rcid, RatingComment ratingComment);

    public void remove(String cid);
}
