package com.mtli.lms.librarymanager.service.impl;

import com.mtli.lms.librarymanager.mapper.BookMapper;
import com.mtli.lms.librarymanager.mapper.ReaderMapper;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void add(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void delete(Book book) {
        bookMapper.deleteBook(book);
    }

    @Override
    public void update(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public List<Book> selectByConditions(Book book) {
        return bookMapper.selectBookByConditions(book);
    }

    @Override
    public List<Book> selectAllBook() {
        return bookMapper.selectAllBook();
    }
}
