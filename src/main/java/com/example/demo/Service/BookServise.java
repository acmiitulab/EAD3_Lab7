package com.example.demo.Service;

import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServise implements IBookServise {

    @Autowired
    private BookRep bookRep;

    public boolean isAvailable (int id) {
        Book book = bookRep.getById(id);
        return book.getAvailable();
    }

    public void update (Book book) {
        bookRep.save(book);
    }

    public Book getByID (int id) {
        return bookRep.getById(id);
    }

    public Book getByName (String name) {
        return bookRep.getByName(name);
    }

    public void deleteByID (long id) {
        bookRep.deleteById(id);
    }

    public List<Book> getAll () {
        return bookRep.findAll();
    }



}
