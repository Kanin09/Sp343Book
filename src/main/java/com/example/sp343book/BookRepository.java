package com.example.sp343book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'isbn' :  ?0}")
    Book findBooksByIsbn(String isbn);


}
