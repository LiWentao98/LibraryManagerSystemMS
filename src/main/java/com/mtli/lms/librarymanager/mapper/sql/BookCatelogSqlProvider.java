package com.mtli.lms.librarymanager.mapper.sql;

import com.mtli.lms.librarymanager.model.BookCatelog;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-09 11:07
 */
public class BookCatelogSqlProvider {
    public String addCatelog(BookCatelog bookCatelog){
        return new SQL(){{
            INSERT_INTO("book_catelog");
            VALUES("c_number, c_name","#{c_number}, #{c_name}");
        }}.toString();
    }
}
