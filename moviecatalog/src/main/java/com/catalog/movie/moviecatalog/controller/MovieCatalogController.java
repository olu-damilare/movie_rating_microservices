package com.catalog.movie.moviecatalog.controller;

import com.catalog.movie.moviecatalog.model.*;
import com.catalog.movie.moviecatalog.services.MovieInfo;
import com.catalog.movie.moviecatalog.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movie;

    @Autowired
    private UserRatingInfo userRatingInfo;

//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public CatalogCollection getCatalog(@PathVariable("userId") String userId){
        UserRating ratings = userRatingInfo.getUserRating(userId);

        return movie.getCatalogCollection(ratings);

    }






}

