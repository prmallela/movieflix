package com.prmallela.app.service;


import com.prmallela.app.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findOne(String uid);

    public List<User> findByFirstName(String firstname);

    public List<User> findByLastName(String lastname);

    public User findByEmail(String email);

    public User Create(User user);

    public User update(String uid, User user);

    public void remove(String uid);
}
