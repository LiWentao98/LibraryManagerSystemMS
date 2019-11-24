package com.mtli.lms.librarymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtli.lms.librarymanager.mapper.BookMapper;
import com.mtli.lms.librarymanager.mapper.ReaderMapper;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Reader;
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

    /**
     * 通过分类号分页查询图书
     * @param pageNum
     * @param b_catalog
     * @return
     */
    @Override
    public List<Book> searchBookByConditionList(int pageNum ,Integer b_catalog) {
        Book book = new Book();
        book.setB_catalog(b_catalog);
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Book> bookList = bookMapper.selectBookByConditions(book);
        //传入要分页的结果对象
        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList);
        //得到分页中的Question条目对象
        List<Book> pageList = bookPageInfo.getList();
        return pageList;
    }

    @Override
    public List<Book> selectAllBook() {
        return bookMapper.selectAllBook();
    }

    /**
     * 通过分类号查询其图书数量
     * @param b_catalog
     * @return
     */
    @Override
    public int searchBookCountByCatalog(Integer b_catalog) {
        return bookMapper.searchBookCount(b_catalog);
    }

    @Override
    public Book searchBookByBId(Integer b_id) {
        return bookMapper.searchBookByBId(b_id);
    }

    @Override
    public List<Book> searchBookLastCode() {
        return bookMapper.searchBookCode();
    }

    @Override
    public int searchBookCountByConditions(Book book) {
        return bookMapper.selectBookCountByConditions(book);
    }


}

