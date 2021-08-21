package com.example.movie_rating.repository;

import com.example.movie_rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
//    @Query(value = "SELECT avg(movie_rating.rating) FROM Rating movie_rating")
    @Query(value = "SELECT AVG(rating) FROM rating WHERE movie_id= ?1", nativeQuery = true)
    Double getRating(Integer movieId);
}
