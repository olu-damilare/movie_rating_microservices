package com.catalog.movie.moviecatalog.controller;

import com.catalog.movie.moviecatalog.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

    @RequestMapping("/{userId}")
    public CatalogCollection getCatalog(@PathVariable("userId") String userId){
        UserRating ratings = restTemplate.getForObject("http://movie-rating-service/users/" + userId, UserRating.class);

        List<CatalogItem> items = ratings.getUserRating().stream().map(rating -> {
          Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId() + "/", Movie.class);

            assert movie != null;
            return new CatalogItem(movie.getTitle(), movie.getSynopsis(), rating.getRating());

    }).collect(Collectors.toList());

        CatalogCollection collection = new CatalogCollection();
        collection.setItems(items);
        return collection;

    }
}
