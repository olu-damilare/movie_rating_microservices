package com.catalog.movie.moviecatalog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Integer ratingId;
    private Number rating;
    private String comment;
    private Integer movieId;

    public Rating(Integer rating, String comment, Integer movieId){
        this.rating = rating;
        this.comment = comment;
        this.movieId = movieId;
    }

    public Rating(Integer movieId, Double rating){
        this.movieId = movieId;
        this.rating = rating;
    }
}

