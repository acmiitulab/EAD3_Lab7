package com.example.demo.Controller;


import com.example.demo.Models.Book;
import com.example.demo.Models.User;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookServise bookServise;


    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookServise.getAll();
    }

    @GetMapping("/{id}")
    public Book getAllBooks(@PathVariable("id") int id) {
        return bookServise.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable("id") long id) {
        bookServise.deleteByID(id);
    }


    @PostMapping("")
    public void createBook(
            @RequestBody Book book
    ) {

        bookServise.update(book);

    }

    @PutMapping("")
    public void updateBook(
            @RequestBody Book book

    ) {

        bookServise.update(book);
    }
}
