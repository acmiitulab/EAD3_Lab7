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
            @RequestParam("name") String name,
            @RequestParam("isAvailable") boolean isAvailable

    ) {

        Book book = new Book(0, name, isAvailable);

        bookServise.update(book);

    }

    @PutMapping("")
    public void updateBook(
            @RequestParam("id") int id,
            @RequestParam("name") String name
    ) {
        Book book = bookServise.getByID(id);
        if (book == null) {
            return;
        }
        book.setName(name);
        bookServise.update(book);
    }
}
