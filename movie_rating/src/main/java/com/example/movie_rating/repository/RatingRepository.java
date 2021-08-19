package com.example.movie_rating.repository;

import com.example.movie_rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT AVG(movie_rating.rating) FROM Rating movie_rating WHERE movie_rating.ratingId= ?1", nativeQuery = true)
    Rating getRating(Integer movieId);
}
