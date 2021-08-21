package com.example.movie_rating.controller;


import com.example.movie_rating.exceptions.RatingException;
import com.example.movie_rating.model.Rating;
import com.example.movie_rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/rating")
    public void addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
    }

    @GetMapping("/rating/{movieId}")
    public Rating getRating(@PathVariable Integer movieId) {
        Rating rating = null;
        try {
            rating = ratingService.getRating(movieId);
        } catch (RatingException e) {
            e.printStackTrace();
        }

        return rating;
    }

    @GetMapping("/ratings")
    public List<Rating> findAll() {
        return ratingService.getRatings();
    }


}
