package com.example.demo.Models;

import javax.persistence.*;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Boolean isAvailable;

    @OneToOne(fetch = FetchType.EAGER)
    private TakeBook takeBook;

    public Book(int id, String name, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
    }
    public Book () {

    }

    public String getName() {
        return name;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TakeBook getTakeBook() {
        return takeBook;
    }

    public void setTakeBook(TakeBook takeBook) {
        this.takeBook = takeBook;
    }



}
