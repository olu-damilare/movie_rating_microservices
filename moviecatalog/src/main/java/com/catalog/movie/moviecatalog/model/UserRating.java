package com.catalog.movie.moviecatalog.model;

import lombok.Data;

import java.util.List;


@Data
public class UserRating {

    private List<Rating> userRating;
    private String userId;

    public UserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }

    public UserRating() {
    }
}
