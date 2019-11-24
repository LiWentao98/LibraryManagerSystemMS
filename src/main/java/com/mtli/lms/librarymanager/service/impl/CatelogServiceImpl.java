package com.mtli.lms.librarymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtli.lms.librarymanager.mapper.BookCatelogMapper;
import com.mtli.lms.librarymanager.model.BookCatelog;
import com.mtli.lms.librarymanager.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-09 14:40
 */
@Service
public class CatelogServiceImpl implements CatelogService {

    @Autowired
    private BookCatelogMapper bookCatelogMapper;

    /**
     * 获取所有分类号
     * @return
     */
    @Override
    public List<BookCatelog> searchAllCatelogs() {
        return bookCatelogMapper.getAllCatelog();
    }

    /**
     * 添加分类号
     * @param bookCatelog
     * @return
     */
    public boolean addCatelog(BookCatelog bookCatelog){
        int n = bookCatelogMapper.addCatelog(bookCatelog);
        if(n>0){
            return true;
        }
        return false;
    }

    /**
     * 获取分类号id
     * @param c_name
     * @return
     */
    @Override
    public Integer searchCatelogId(String c_name) {
        return bookCatelogMapper.getCatelogId(c_name);
    }

    /**
     * 分页获取分类号
     * @param pageNum
     * @return
     */
    @Override
    public List<BookCatelog> getBookCatelogList(int pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<BookCatelog> catelogList = bookCatelogMapper.getAllCatelogMessage();
        //传入要分页的结果对象
        PageInfo<BookCatelog> catelogPageInfo = new PageInfo<>(catelogList);
        //得到分页中的Question条目对象
        List<BookCatelog> pageList = catelogPageInfo.getList();
        return pageList;
    }

    @Override
    public Integer getCatelogCount() {
        return bookCatelogMapper.getCatelogCount();
    }

    @Override
    public List<BookCatelog> getAllCatelogMessage() {
        return getAllCatelogMessage();
    }

    @Override
    public int deleteCatelog(int c_id) {
        return bookCatelogMapper.deleteCatelog(c_id);
    }
}
