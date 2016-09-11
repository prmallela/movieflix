package com.prmallela.app.controller;


import com.prmallela.app.entity.Movie;
import com.prmallela.app.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

    @Autowired
    private MovieService service;

    //For Getting All Movies
    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> findAll(){
        return service.findAll();
    }

    //For Getting Movie based on mid
    @RequestMapping(method = RequestMethod.GET, value = "{mid}")
    public Movie findOne(@PathVariable("mid") String mid){
        return service.findOne(mid);
    }

    //For Finding Movie based on Title
    @RequestMapping(method = RequestMethod.GET,value = "{title}")
    public Movie findByTitle(@PathVariable("title") String title){
        return service.findByTitle(title);
    }

    //For finding Movie's based on Year
    @RequestMapping(method = RequestMethod.GET, value = "{year}")
    public List<Movie> findByYear(@PathVariable("year") int year){
        return service.findByYear(year);
    }

    //For finding Movie Based on imdbid
    @RequestMapping(method = RequestMethod.GET, value = "{imdbid}")
    public Movie findByImdbid(@PathVariable("imdbid") String imdbid){
        return service.findByImdbId(imdbid);
    }

    //For Creating Movie
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie create(@RequestBody Movie movie){
        return service.create(movie);
    }

    //For Updating Movie
    @RequestMapping(method = RequestMethod.PUT, value ="{mid}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie update(@PathVariable("mid") String mid, @RequestBody Movie mov){
        return service.update(mid,mov);
    }

    //For Deleting Movie
    @RequestMapping(method = RequestMethod.DELETE,value = "{mid}")
    public void delete(@PathVariable("mid") String mid){
        service.remove(mid);
    }


}
