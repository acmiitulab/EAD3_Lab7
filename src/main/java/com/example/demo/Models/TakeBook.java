package com.example.demo.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
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


}
