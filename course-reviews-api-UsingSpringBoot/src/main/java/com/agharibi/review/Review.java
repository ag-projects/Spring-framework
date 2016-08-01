package com.agharibi.review;


import com.agharibi.core.BaseEntity;
import com.agharibi.course.Course;
import com.agharibi.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends BaseEntity{

    private int rating;
    private String description;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User reviewer;

    protected Review() {
        super();
    }

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
