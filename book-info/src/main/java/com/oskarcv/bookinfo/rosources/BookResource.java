package com.oskarcv.bookinfo.rosources;

import com.oskarcv.bookinfo.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookResource {
    @RequestMapping("/{bookId}")
    public Book getBook(@PathVariable("bookId") String bookId){
        return new Book(bookId,"Java 8 In Action");
    }
}
