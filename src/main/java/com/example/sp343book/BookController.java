package com.example.sp343book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/book")
    List<Book> getAllBook(){
        return repo.findAll();
    }
    @GetMapping("/book/isbn/{isbn}")
    List<Book> findBooksByIsbn( @PathVariable String isbn) {
        return repo.findBooksByIsbn(isbn);
    }
    @GetMapping("/book/title/{title}")
    List<Book> findBooksByTitle(@PathVariable String title) {
        return repo.findBooksByTitle(title);
    }
    @GetMapping("/book/pageCount/{gte}/{lte}")
    List<Book> findBooksByPageCount(@PathVariable int gte, @PathVariable int lte) {
        return repo.findBooksByPageCount(gte, lte);
    }
}
