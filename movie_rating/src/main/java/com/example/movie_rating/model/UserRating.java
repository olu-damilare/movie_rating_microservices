package com.example.movie_rating.model;

import lombok.Data;

import java.util.List;


@Data
public class UserRating {

    private List<Rating> userRating;

    public UserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

    public UserRating() {

    }
}
