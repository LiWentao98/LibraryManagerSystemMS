package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.BookCatelog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:分类号管理业务
 * @Author: Mt.Li
 * @Create: 2019-11-09 14:39
 */
@Service
public interface CatelogService {
    //查询所有分类号
    List<BookCatelog> searchAllCatelogs();
    //添加分类号
    boolean addCatelog(BookCatelog bookCatelog);
    //查询分类号id
    Integer searchCatelogId(String c_name);
    //分页获取分类号
    List<BookCatelog> getBookCatelogList(int pageNum);
    //获取分类号数目
    Integer getCatelogCount();
    //获取分类号所有信息
    List<BookCatelog> getAllCatelogMessage();
    //删除分类号
    int deleteCatelog(int c_id);
}
