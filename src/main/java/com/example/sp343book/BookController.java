package com.example.sp343book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/book")
    String getBookisbn(Model model) {
       model.addAttribute("books", new Book());
       return "addbook";
    }
    @PostMapping("/addbook")
    String submidBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("books", repo.findBooksByIsbn(book.getIsbn()));
        return "result";
    }


//    @GetMapping("/addbook")
//    String addBook(Model model) {
//        model.addAttribute("book", new Book());
//        return "addbook";
//    }
//    @PostMapping("/addbook")
//    String submitBooks(@ModelAttribute Book book, Model model) {
//        model.addAttribute("book", book);
//        repo.save(book);
//        return "result";
//
//    }

}
