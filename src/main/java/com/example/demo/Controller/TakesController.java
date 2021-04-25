package com.example.demo.Controller;


import com.example.demo.Models.Book;
import com.example.demo.Models.TakeBook;
import com.example.demo.Models.User;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/takes")
public class TakesController {

    @Autowired
    private itakesServise takesServise;

    @Autowired
    private BookServise bookServise;

    @Autowired
    private UserServise userServise;


    @GetMapping("")
    public List<TakeBook> getTakes() {
        return takesServise.getAll();
    }

    @GetMapping("/{id}")
    public TakeBook getTakByID (@PathVariable("id") int id) {
        return takesServise.getByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTakesByID(@PathVariable("id") long id) {
        takesServise.DeleteById(id);
    }


    @PostMapping("")
    public void createTakes( @RequestParam("username") String name, @RequestParam("book") List<String> books) {
        User user =  userServise.getByUsername(name);
        if (user == null) {
            return;
        }
        ArrayList<Book> booksToTake = new ArrayList<>();
        for (String id : books ) {

            Book book =  bookServise.getByID(Integer.parseInt(id));
            if (book == null ) {
                continue;
            }
            if (!book.getAvailable())
                continue;

            book.setAvailable(false);
            bookServise.update(book);
            booksToTake.add(book);

        }
        if (booksToTake.size() == 0) {
            return;
        }
        TakeBook takeBook = new TakeBook(0, user, booksToTake, false);
        takesServise.Update(takeBook);


    }

    @PutMapping("")
    public void updateUser( @RequestParam("id") int id, @RequestParam("isReturned") boolean isReturned) {


        TakeBook takeBook = takesServise.getByID(id);
        takeBook.setActive(isReturned);
        for (Book book : takeBook.getBooks()) {
            book.setAvailable(isReturned);
            bookServise.update(book);
        }
        takesServise.Update(takeBook);

    }



}
