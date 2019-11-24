package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.BookCatelogSqlProvider;
import com.mtli.lms.librarymanager.model.BookCatelog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:分类号数据库操作
 * @Author: Mt.Li
 * @Create: 2019-11-09 11:06
 */
@Repository
public interface BookCatelogMapper {
    //获取所有分类号
    @Select("select * from book_catelog")
    List<BookCatelog> getAllCatelog();
    //获取分类号所有信息
    @Select("select * from book_catelog")
    List<BookCatelog> getAllCatelogMessage();
    //新添分类号
    @InsertProvider(type = BookCatelogSqlProvider.class,method = "addCatelog")
    Integer addCatelog(BookCatelog bookCatelog);
    //根据分类号名称获取分类号id
    @Select("select c_id from book_catelog where c_name = #{c_name}")
    Integer getCatelogId(String c_name);
    //获取分类号数目
    @Select("select count(c_id) from book_catelog")
    Integer getCatelogCount();
    //删除分类号
    @Delete("delete from book_catelog where c_id = #{c_id}")
    int deleteCatelog(int c_id);
}
