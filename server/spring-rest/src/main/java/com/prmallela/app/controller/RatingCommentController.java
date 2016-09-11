package com.prmallela.app.controller;


import com.prmallela.app.entity.RatingComment;
import com.prmallela.app.service.RatingCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "ratingcomments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RatingCommentController {

    @Autowired
    private RatingCommentService service;

    //For Getting All Rating and Commets for a movie with mid
    @RequestMapping(method = RequestMethod.GET, value = "{mid}")
    public List<RatingComment> findAll(@PathVariable("mid") String mid){
        return service.findAll(mid);
    }

    //For Creating Rating or Comment need mid,uid,RatingComment object
    @RequestMapping(method = RequestMethod.POST, value ="{mid}/{uid}" ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RatingComment create(@RequestBody RatingComment ratingComment,
                                @PathVariable("mid")String mid,
                                @PathVariable("uid") String uid){
        return service.create(mid,uid,ratingComment);
    }

    //For Updating RatingComment object
    @RequestMapping(method = RequestMethod.PUT,value = "{rcid}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RatingComment update(@PathVariable("rcid") String rcid, @RequestBody RatingComment ratingComment){
        return service.update(rcid,ratingComment);
    }

    //For deleting RatingComment
    @RequestMapping(method = RequestMethod.DELETE,value = "{rcid}")
    public void delete(@PathVariable("rcid") String rcid){
        service.remove(rcid);
    }
}
