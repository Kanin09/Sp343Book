package com.example.sp343book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'isbn' :  ?0}")
    List<Book> findBooksByIsbn(String isbn);


    @Query("{'title' : {$regex : ?0}}")
    List<Book> findBooksByTitle(String title);

    @Query("{'pageCount' : {$gte : ?0 ,$lte: ?1 }}")
    List<Book> findBooksByPageCount(int gte, int lte);

}
