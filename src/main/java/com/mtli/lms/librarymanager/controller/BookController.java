package com.mtli.lms.librarymanager.controller;


import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.service.impl.BookServiceImpl;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 图书表示控制层
 * @Author: Mt.Li
*/

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @ResponseBody
    @PostMapping("/add_book")
    void addBook(@RequestParam(value = "b_cover",required=false) String bCover,@RequestBody Book book){
        byte[] b_cover = bCover.getBytes();
        book.setB_cover(b_cover);
        bookService.add(book);
    }

    @ResponseBody
    @DeleteMapping("/delete_book")
    void deleteBook(@RequestBody Book book){
        bookService.delete(book);
    }

    @ResponseBody
    @PutMapping("/update_book")
    void updateBook(@RequestBody Book book){
        bookService.update(book);
    }

    @ResponseBody
    @GetMapping("/select_book_by_conditions")
    List<Book> selectBookByConditions(@RequestBody Book book){
        return bookService.selectByConditions(book);
    }

}
