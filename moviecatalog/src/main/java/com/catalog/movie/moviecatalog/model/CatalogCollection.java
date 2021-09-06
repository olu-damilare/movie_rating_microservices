package com.catalog.movie.moviecatalog.model;

import lombok.Data;

import java.util.List;

@Data
public class CatalogCollection {

    List<CatalogItem> items;

    public CatalogCollection() {
    }

    public CatalogCollection(List<CatalogItem> items) {
        this.items = items;
    }
}
