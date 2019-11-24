package com.mtli.lms.librarymanager;

import com.mtli.lms.librarymanager.model.Book;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-12 15:59
 */
public class test1 {
    public String insertBook(Book book){
        return new SQL(){{
            INSERT_INTO("book");
            VALUES("b_id, b_code","#{b_id}, #{b_code}");
            VALUES("b_name, b_author","#{b_name}, #{b_author}");
            VALUES("b_press, b_date_press","#{b_press}, #{b_date_press}");
            VALUES("b_isbn, b_catalog","#{b_isbn}, #{b_catalog}");
            VALUES("b_language, b_pages","#{b_language}, #{b_pages}");
            VALUES("b_price, b_date_in","#{b_price}, #{b_date_in}");
            VALUES("b_status","#{b_status}");
        }}.toString();
    }


}

