package com.oskarcv.ratingbook.resources;

import com.oskarcv.ratingbook.resources.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-rating")
public class BookRating {
    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId){
        return new Rating(bookId,5);
    }
}
