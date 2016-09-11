package com.prmallela.app.entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u from User u ORDER BY u.firstname"),
        @NamedQuery(name = "User.findByFirstName", query = "SELECT u from User u where u.firstname=:pfirstname"),
        @NamedQuery(name = "User.findByLastName", query = "SELECT u from User u where u.lastname=:plastname"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u from User u where u.email=:pemail")
})
public class User {
    @Id
    private String uid;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    private String type;

    public User() {
        uid = UUID.randomUUID().toString();
        type = "user";
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

   /* public void setPassword(String password) throws NoSuchAlgorithmException {
        SaltedHashedPassword origHashed = SaltedHashedPassword.generate(password);
        this.password = origHashed.toString();
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
