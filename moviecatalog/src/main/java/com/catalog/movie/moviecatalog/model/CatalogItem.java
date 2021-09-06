package com.catalog.movie.moviecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogItem {

    private String title;
    private String desc;
    private Number rating;
}
