package com.prmallela.app.service;


import com.prmallela.app.entity.User;
import com.prmallela.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOne(String uid) {
        User user = repository.findOne(uid);
        if(user ==null){
            throw new EntityNotFoundException("User Not Found");
        }
        return user;
    }

    @Override
    public List<User> findByFirstName(String firstname) {
        List<User> users = repository.findByFirstName(firstname);
        if(users.isEmpty()){
            throw new EntityNotFoundException("No User Found");
        }
        return users;
    }

    @Override
    public List<User> findByLastName(String lastname) {
        List<User> users = repository.findByLastName(lastname);
        if(users.isEmpty()){
            throw new EntityNotFoundException("No User Found");
        }
        return users;
    }

    @Override
    public User findByEmail(String email) {
        User user = repository.findByEmail(email);
        if(user == null){
            throw new EntityNotFoundException("No User Found");
        }
        return user;
    }

    @Transactional
    @Override
    public User Create(User user) {
        User u = repository.findOne(user.getUid());
        if (u != null) {
        throw new EntityNotFoundException("User Already Exits");
        }
        return repository.Create(user);
    }

    @Transactional
    @Override
    public User update(String uid, User user) {
        User u = repository.findOne(uid);
        if(u ==null){
            throw new EntityNotFoundException("User Not Found");
        }
        return repository.update(user);
    }

    @Transactional
    @Override
    public void remove(String uid) {
        User user = repository.findOne(uid);
        if(user ==null){
            throw new EntityNotFoundException("User not found");
        }
        repository.remove(user);
    }
}
