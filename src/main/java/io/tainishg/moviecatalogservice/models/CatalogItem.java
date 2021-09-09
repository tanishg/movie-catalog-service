package io.tainishg.moviecatalogservice.models;

import lombok.Data;

@Data
public class CatalogItem {

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public CatalogItem() {
    }

    private String name;
    private String desc;
    private int rating;
    
}
