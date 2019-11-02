package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.BooksqlProvider;
import com.mtli.lms.librarymanager.mapper.sql.ReaderSqlProvider;
import com.mtli.lms.librarymanager.model.Book;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 图书数据操作
 * @Author: Mt.Li
*/

@Repository
public interface BookMapper {
    //添加图书
    @InsertProvider(type = BooksqlProvider.class,method = "insertBook")
    void addBook(Book book);
    //图书删除
    @DeleteProvider(type = BooksqlProvider.class,method = "deleteBook")
    void deleteBook(Book book);
    //图书信息更改
    @UpdateProvider(type = BooksqlProvider.class,method = "editBook")
    void updateBook(Book book);
    //根据其他条件查询图书
    @SelectProvider(type = BooksqlProvider.class,method = "selectBookByConditions")
    List<Book> selectBookByConditions(Book book);
    //查询所有图书
    @SelectProvider(type = BooksqlProvider.class,method = "selectAll")
    List<Book> selectAllBook();
}
