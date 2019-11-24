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
    //根据图书条件查询(分页)
     List<Book> searchBookByConditionList(int pageNum,Integer b_catalog);
    //查询所有图书
    List<Book> selectAllBook();
    //查询符合某个分类的图书数量
    int searchBookCountByCatalog(Integer b_catalog);
    //通过图书id查询图书
    Book searchBookByBId(Integer b_id);
    //查询book表最后一项书的图书编号
    List<Book> searchBookLastCode();
    //
    int searchBookCountByConditions(Book book);
}
