package com.example.demo.Service;

import com.example.demo.Models.TakeBook;

import java.util.List;

public interface itakesServise {

     TakeBook getByID (int id) ;

     List<TakeBook> getByUserID (int id) ;

     void Update (TakeBook takeBook) ;

     void DeleteById (long id);

     List<TakeBook> getAll ();

}
