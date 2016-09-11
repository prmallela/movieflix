package com.prmallela.app.controller;


import com.prmallela.app.entity.User;
import com.prmallela.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService service;

    //For Getting All User's may be for Admin
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll(){
        return service.findAll();
    }

    //For finding user based on uid
    @RequestMapping(method = RequestMethod.GET, value = "{uid}")
    public User findOne(@PathVariable("uid") String uid){
        return service.findOne(uid);
    }

    //For finding User based on firstname
    @RequestMapping(method = RequestMethod.GET, value = "{firstname}")
    public List<User> findByFirstName(@PathVariable("firstname") String firstname){
        return service.findByFirstName(firstname);
    }
    //For finding user based on lastname
    @RequestMapping(method = RequestMethod.GET, value = "{lastname}")
    public List<User> findByLastName(@PathVariable("lastname") String lastname){
        return service.findByLastName(lastname);
    }

    //for finding user based on email
    @RequestMapping(method = RequestMethod.GET, value = "{email}")
    public User findByEmail(@PathVariable("email") String email){
        return service.findByEmail(email);
    }

    //For creating User
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User Create(@RequestBody User user){
        return service.Create(user);
    }

    //For Updating User
    @RequestMapping(method = RequestMethod.PUT, value = "{uid}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User update(@PathVariable String uid, @RequestBody User user){
        return service.update(uid,user);
    }

    //For Deleting User
    @RequestMapping(method = RequestMethod.DELETE, value = "{uid}")
    public void remove(@PathVariable("uid") String uid){
      service.remove(uid);
    }
}
