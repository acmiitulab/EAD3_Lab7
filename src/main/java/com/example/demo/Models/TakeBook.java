package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class TakeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    @JoinTable(
            name = "taken_books",
            joinColumns = @JoinColumn(name = "take_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    private Boolean isReturned;

    public TakeBook(int id, User user, List<Book> books, Boolean isReturned) {
        this.id = id;
        this.user = user;
        this.books = books;
        this.isReturned = isReturned;
    }

    public TakeBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getActive() {
        return isReturned;
    }

    public void setActive(Boolean active) {
        isReturned = active;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Boolean isDone() {
        return isReturned;
    }

    public void setDone(Boolean done) {
        isReturned = done;
    }
}
