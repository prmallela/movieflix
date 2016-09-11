package com.prmallela.app.entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@NamedQueries({
})
public class RatingComment {

    @Id
    private String rcid;
    private double rating;
    private String comment;

    @OneToOne
    private User user;


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RatingComment(){
        rcid = UUID.randomUUID().toString();
    }

    public String getRcid() {
        return rcid;
    }

    public void setRcid(String rcid) {
        this.rcid = rcid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
