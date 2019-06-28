package com.sqc.springboot.service.impl;

import com.sqc.springboot.domain.Book;
import com.sqc.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 孙启超
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    JpaRepository repository;


    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return (Book) repository.save(book);
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
