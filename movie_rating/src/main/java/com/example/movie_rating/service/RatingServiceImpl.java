package com.example.movie_rating.service;

import com.example.movie_rating.exceptions.RatingException;
import com.example.movie_rating.model.Rating;
import com.example.movie_rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    RatingRepository ratingRepository;

    @Override
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(Integer movieId) throws RatingException {
        Double movieRating = ratingRepository.getRating(movieId);
        return new Rating(movieId, movieRating);

    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }
}
