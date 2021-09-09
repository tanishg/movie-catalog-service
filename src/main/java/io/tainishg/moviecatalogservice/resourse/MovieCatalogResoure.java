package io.tainishg.moviecatalogservice.resourse;

import io.tainishg.moviecatalogservice.models.CatalogItem;
import io.tainishg.moviecatalogservice.services.MovieCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResoure {

    @Autowired
    private MovieCatalogService movieCatalogService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItemByUserId(@PathVariable("userId") String userId) {
        return movieCatalogService.getCatalogItemByUserId(userId);
    }

    @RequestMapping
    public List<CatalogItem> getCatalogItems() {
        return movieCatalogService.getCatalogItems();
    }

}
