package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.BookSqlProvider;
import com.mtli.lms.librarymanager.model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 图书数据操作
 * @Author: Mt.Li
*/

@Repository
public interface BookMapper {
    //添加图书
    @InsertProvider(type = BookSqlProvider.class,method = "insertBook")
    int addBook(Book book);
    //图书删除
    @DeleteProvider(type = BookSqlProvider.class,method = "deleteBook")
    void deleteBook(Book book);
    //图书信息更改
    @UpdateProvider(type = BookSqlProvider.class,method = "editBook")
    void updateBook(Book book);
    //根据其他条件查询图书
    @SelectProvider(type = BookSqlProvider.class,method = "selectBookByConditions")
    List<Book> selectBookByConditions(Book book);
    //根据其他条件查询图书count
    @SelectProvider(type = BookSqlProvider.class,method = "selectBookCountByConditions")
    int selectBookCountByConditions(Book book);
    //查询所有图书
    @SelectProvider(type = BookSqlProvider.class,method = "selectAll")
    List<Book> selectAllBook();
    //查询符合条某一个分类的图书的数量
    @Select("select count(b_catalog) from book where b_catalog = #{b_catalog}")
    int searchBookCount(Integer b_catalog);
    //通过图书id查询图书
    @Select("select * from book where b_id = #{b_id}")
    Book searchBookByBId(Integer b_id);
    //查询book表最后一项书的图书编号
    @Select("SELECT * FROM book ORDER BY b_id DESC LIMIT 1")
    List<Book> searchBookCode();
}
