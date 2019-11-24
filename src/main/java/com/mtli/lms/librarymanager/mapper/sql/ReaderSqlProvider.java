package com.mtli.lms.librarymanager.mapper.sql;

import com.mtli.lms.librarymanager.model.Reader;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-10-26 21:19
 */

public class ReaderSqlProvider {

    /**
     * 添加读者sql
     * @return
     */
   public String insertReader(){
       return new SQL(){{
          INSERT_INTO("reader");
          VALUES("r_id, r_name","#{r_id}, #{r_name}");
          VALUES("r_sex, r_dept","#{r_sex}, #{r_dept}");
          VALUES("r_phone, r_email","#{r_phone}, #{r_email}");
          VALUES("r_date_reg, r_photo","#{r_date_reg}, #{r_photo}");
          VALUES("r_status","#{r_status}");
          VALUES("a_id","#{a_id}");
          VALUES("r_type","#{r_type}");
       }}.toString();
   }

    /**
     * 删除读者sql
     * @param r_id
     * @return
     */
   public String deleteReader(Integer r_id){
       return new SQL(){{
           DELETE_FROM("reader");
           if(r_id !=null){
               WHERE("r_id = #{r_id}");
           }
       }}.toString();
   }

    /**
     * 编辑读者
     * @param reader
     * @return
     */
    public String editReader(Reader reader){
        return new SQL(){{
            UPDATE("reader");
            if(reader.getR_dept() !=null){
                SET("r_dept = #{r_dept}");
            }
            if(reader.getR_phone() !=null){
                SET("r_phone = #{r_phone}");
            }
            if(reader.getR_email() !=null){
                SET("r_email = #{r_email}");
            }
            if(reader.getR_photo() !=null){
                SET("r_photo = #{r_photo}");
            }
            if(reader.getR_type() !=null){
                SET("r_type = #{r_type}");
            }
            if(reader.getR_pwd() !=null){
                SET("r_pwd = #{r_pwd}");
            }
            if(reader.getR_status() !=null){
                SET("r_status = #{r_status}");
            }
            if(reader.getR_borrow_q() !=null){
                SET("r_borrow_q = #{r_borrow_q}");
            }
            if(reader.getR_id() !=null){
                WHERE("r_id = #{r_id}");
            }
        }}.toString();
    }

    public String selectReader(Reader reader){
        return new SQL(){{
            SELECT("*");
            FROM("reader");
            if(reader.getR_id() !=null){
                WHERE("r_id = #{r_id}");
            }
        }}.toString();
    }
}
