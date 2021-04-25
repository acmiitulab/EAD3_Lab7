package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Book;

@Repository
public interface BookRep extends JpaRepository<Book, Long> {

    Book getByName(String name);
    Book getById(int id);

}
