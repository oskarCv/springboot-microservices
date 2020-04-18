package com.oskarcv.bookcatalog.resources;

import com.oskarcv.bookcatalog.models.Book;
import com.oskarcv.bookcatalog.models.CatalogItem;
import com.oskarcv.bookcatalog.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        //TODO: get all related books
        RestTemplate restTemplate = new RestTemplate();

        List<Rating> ratings = Arrays.asList(
                new Rating("123",5),
                new Rating("456",4)
        );
        return ratings.stream()
                .map(rating ->{
                    Book book = restTemplate.getForObject("http://localhost:8082/books/"+rating.getBookId(), Book.class);
                    return new CatalogItem(book.getTitle(), "desc",rating.getRating());
                })
                .collect(Collectors.toList());
        //TODO: for each bookid call the boock info and get details
        //TODO: put all the info together
    }
}
