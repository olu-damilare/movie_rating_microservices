package com.example.movie_rating.service;


import com.example.movie_rating.exceptions.RatingException;
import com.example.movie_rating.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    void addRating(Rating rating);

    Rating getRating(Integer movieId) throws RatingException;

    List<Rating> getRatings();

}
