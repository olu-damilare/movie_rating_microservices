package com.catalog.movie.moviecatalog.services;

import com.catalog.movie.moviecatalog.model.CatalogCollection;
import com.catalog.movie.moviecatalog.model.CatalogItem;
import com.catalog.movie.moviecatalog.model.Movie;
import com.catalog.movie.moviecatalog.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogCollection")
    public CatalogCollection getCatalogCollection(UserRating ratings) {
        List<CatalogItem> items = ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId() + "/", Movie.class);
            assert movie != null;
            return new CatalogItem(movie.getTitle(), movie.getSynopsis(), rating.getRating());
        }).collect(Collectors.toList());

        CatalogCollection collection = new CatalogCollection();
        collection.setItems(items);
        return collection;
    }

    public CatalogCollection getFallbackCatalogCollection(@PathVariable("userId") UserRating userRating) {
        Number rating = userRating.getUserRating().get(0).getRating();
        List<CatalogItem> fallbackItem = Arrays.asList(new CatalogItem("Movie name is unavailable", "", rating));
        CatalogCollection collection = new CatalogCollection();
        collection.setItems(fallbackItem);
        return collection;

    }
}
