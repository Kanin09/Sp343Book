package com.example.sp343book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Sp343bookApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Sp343bookApplication.class, args);
    }

    @Autowired
    BookRepository repo;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");

    }
    private void showAllItem() {
        List<Book> books = repo.findAll();
        System.out.println(books.size());
        for (Book book : books) {
            System.out.println(book.getId() + " - " + book.getTitle()+ " - " + book.getIsbn());
        }
    }


}
