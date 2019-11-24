package com.mtli.lms.librarymanager.mapper.sql;

import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Reader;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-10-29 08:45
 */
public class BookSqlProvider {
    /**
     * 添加图书
     * @param book
     * @return
     */
    public String insertBook(Book book){
        return new SQL(){{
            INSERT_INTO("book");
            VALUES("b_code","#{b_code}");
            VALUES("b_name, b_author","#{b_name}, #{b_author}");
            VALUES("b_press, b_date_press","#{b_press}, #{b_date_press}");
            VALUES("b_isbn, b_catalog","#{b_isbn}, #{b_catalog}");
            VALUES("b_language, b_pages","#{b_language}, #{b_pages}");
            VALUES("b_price, b_date_in","#{b_price}, #{b_date_in}");
            VALUES("b_brief, b_cover","#{b_brief}, #{b_cover}");
            VALUES("b_status, b_repertory","#{b_status}, #{b_repertory}");
        }}.toString();
    }

    /**
     * 删除图书
     * @param book
     * @return
     */
    public String deleteBook(Book book){
        return new SQL(){{
            DELETE_FROM("book");
            if(book.getB_id() !=null){
                WHERE("b_id = #{b_id}");
            }
            if(book.getB_code() != null){
                WHERE("b_code = #{b_code}");
            }
            if(book.getB_name() != null){
                WHERE("b_name = #{b_name}");
            }
            if(book.getB_isbn() != null){
                WHERE("b_isbn = #{b_isbn}");
            }
        }}.toString();
    }

    /**
     * 编辑图书
     * @param book
     * @return
     */
    public String editBook(Book book){
        return new SQL(){{
            UPDATE("book");
            if(book.getB_code() !=null){
                SET("b_code = #{b_code}");
            }
            if(book.getB_name() !=null){
                SET("b_name = #{b_name}");
            }
            if(book.getB_author() !=null){
                SET("b_author = #{b_author}");
            }
            if(book.getB_price() !=null){
                SET("b_price = #{b_price}");
            }
            if(book.getB_brief() !=null){
                SET("b_brief = #{b_brief}");
            }
            if(book.getB_cover() !=null){
                SET("b_cover = #{b_cover}");
            }
            if(book.getB_status() !=null){
                SET("b_status = #{b_status}");
            }
            if(book.getB_repertory() !=null){
                SET("b_repertory = #{b_repertory}");
            }
            if(book.getB_id() !=null){
                WHERE("b_id = #{b_id}");
            }
        }}.toString();
    }

    //根据条件搜索，包含模糊搜索
    public String selectBookByConditions(Book book){
        return new SQL(){{
            SELECT("*");
            FROM("book");
            if(book.getB_name() !=null){
                WHERE("b_name like CONCAT('%',#{b_name},'%')");
            }
            if(book.getB_author() !=null){
                WHERE("b_author = #{b_author}");
            }
            if(book.getB_press() !=null){
                WHERE("b_press = #{b_press}");
            }
            if(book.getB_isbn() !=null){
                WHERE("b_isbn = #{b_isbn}");
            }
            if(book.getB_catalog() !=null){
                WHERE("b_catalog = #{b_catalog}");
            }
            if(book.getB_language() !=null){
                WHERE("b_language = #{b_language}");
            }
            if(book.getB_status() !=null){
                WHERE("b_status = #{b_status}");
            }
        }}.toString();
    }

    public String selectBookCountByConditions(Book book){
        String sql = "select count(b_id) from book where b_name like CONCAT('%',#{b_name},'%')";
        if(book.getB_author()!=null){
            sql += " and b_author = #{b_author}";
        }
        if(book.getB_catalog()!=null){
            sql += " and b_catalog = #{b_catalog}";
        }
        if(book.getB_press()!=null){
            sql += " and b_press = #{b_press}";
        }
        return sql;
//        return new SQL(){{
//            SELECT("count(b_id)");
//            FROM("book");
//            if(book.getB_name() !=null){
//                WHERE("b_name like CONCAT('%',#{b_name},'%')");
//            }
//            if(book.getB_author() !=null){
//                AND() ;
//            }
//            if(book.getB_press() !=null){
//                WHERE("b_press = #{b_press}");
//            }
//            if(book.getB_catalog() !=null){
//                WHERE("b_catalog = #{b_catalog}");
//            }
//        }}.toString();
    }

    public String selectAll(){
        return new SQL(){{
            SELECT("*");
            FROM("book");
        }}.toString();
    }







}
