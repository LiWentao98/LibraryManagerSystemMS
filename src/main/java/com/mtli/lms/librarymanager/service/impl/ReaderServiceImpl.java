package com.mtli.lms.librarymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtli.lms.librarymanager.mapper.BookMapper;
import com.mtli.lms.librarymanager.mapper.ReaderMapper;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    private ReaderMapper readerMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int add(Reader reader) {
        return 0;
    }

    @Override
    public int delete(Integer r_id) {
        return readerMapper.delete(r_id);
    }

    @Override
    public boolean updateUser(Reader reader) {
        int readerList = readerMapper.edit(reader);
        if(readerList!=0) {
            return true;
        }
        return false;
    }

    @Override
    public Reader select(Reader reader) {
        return null;
    }

    @Override
    public Reader searchReader(Reader reader) {
        if(reader.getR_id() !=null){
            List<Reader> reader1 = readerMapper.selectReader(reader);
            if(reader1 == null){
                return null;
            }
            for(Reader r:reader1){
                if(r.getR_pwd().equals(reader.getR_pwd())){
                    return r;
                }
            }
            return null;
        }
        return null;
    }



    @Override
    public Integer searchCount() {
        return readerMapper.searchCount();
    }

    @Override
    public List<Reader> searchNewReader(Reader reader) {
        return readerMapper.selectNewReader(reader);
    }

    @Override
    public List<Book> searchBooks(Book book) {
//        //设置起始点
//        PageHelper.startPage(pageNum,5);
//        //获取结果集
//        List<Book> bookList =
//        //传入要分页的结果对象
//        PageInfo<Book> bookPageInfo = new PageInfo<>(bookList);
//        //得到分页中的Question条目对象
//        List<Book> pageList = bookPageInfo.getList();
        return bookMapper.selectBookByConditions(book);
    }

    @Override
    public String searchName(Integer r_id) {
        Reader reader = new Reader();
        reader.setR_id(r_id);
        List<Reader> r = readerMapper.selectReader(reader);
        if(r!=null) {
            for (Reader r1 : r) {
                return r1.getR_name();
            }
        }
        return null;
    }

    @Override
    public int searchBorrowQ(Integer r_id) {
        int n = readerMapper.searchBorrowQ(r_id);
        if(n>0) {
            return readerMapper.searchBorrowQ(r_id);
        }
        return 0;
    }

    @Override
    public Reader searchJReader(Integer r_id) {
        return readerMapper.selectJReader(r_id);
    }


}
