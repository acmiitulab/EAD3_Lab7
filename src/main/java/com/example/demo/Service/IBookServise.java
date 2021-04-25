package com.example.demo.Service;

import com.example.demo.Models.Book;

import java.util.List;

public interface IBookServise {

     boolean isAvailable (int id) ;

     void update (Book book) ;

     Book getByID (int id) ;

     Book getByName (String name) ;

     void deleteByID (long id);

     List<Book> getAll ();

}
