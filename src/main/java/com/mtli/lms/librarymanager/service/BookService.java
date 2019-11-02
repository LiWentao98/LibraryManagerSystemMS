package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 图书管理业务
 * @Author: Mt.Li
*/
@Service
public interface BookService {
    //图书添加业务
    void add(Book book);
    //图书删除业务(根据条件)
    void delete(Book book);
    //图书信息修改业务
    void update(Book book);
    //根据图书条件查询
    List<Book> selectByConditions(Book book);
    //查询所有图书
    List<Book> selectAllBook();
}
