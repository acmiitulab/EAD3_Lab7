package com.example.demo.Service;

import com.example.demo.Models.TakeBook;
import com.example.demo.Repositories.TakesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class takesServise implements itakesServise {

    @Autowired
    private TakesRep takesRep;

    public TakeBook getByID (int id) {
        return takesRep.getById(id);
    }

    public List<TakeBook> getByUserID (int id) {
        return takesRep.getByUserId(id);
    }

    public void Update (TakeBook takeBook) {
        takesRep.save(takeBook);
    }

    public void DeleteById (long id) {
        takesRep.deleteById(id);
    }

    public List<TakeBook> getAll () {
        return takesRep.findAll();
    }



}
