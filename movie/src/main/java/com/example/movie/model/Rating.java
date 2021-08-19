package com.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    @Id
    private Integer ratingId;
    private Number rating;
    private String comment;
    private Integer movieId;

    public Rating(Integer rating, String comment, Integer movieId){
        this.rating = rating;
        this.comment = comment;
        this.movieId = movieId;
    }
}

