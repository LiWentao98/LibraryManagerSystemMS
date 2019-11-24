package com.mtli.lms.librarymanager.mapper.sql;

import com.mtli.lms.librarymanager.model.Borrow;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-16 16:31
 */
public class BorrowSqlProvider {
    public String addBorrow(Borrow borrow){
        return new SQL(){{
            INSERT_INTO("borrow");
            VALUES("r_id","#{r_id}");
            VALUES("b_id","#{b_id}");
            VALUES("id_date_out, id_date_ret_plan","#{id_date_out}, #{id_date_ret_plan}");
            VALUES("id_date_ret_act, id_over_day","#{id_date_ret_act}, #{id_over_day}");
            VALUES("id_over_money, id_punish_money","#{id_over_money}, #{id_punish_money}");
            VALUES("is_has_return, b_name","#{is_has_return}, #{b_name}");
            VALUES("b_author, r_name","#{b_author}, #{r_name}");
        }}.toString();
    }

    public String updateBorrow(Borrow borrow){
        return new SQL(){{
            UPDATE("borrow");
            if(borrow.getId_continue_times()!=null){
                SET("id_continue_times = #{id_continue_times}");
            }
            if(borrow.getId_date_out()!=null){
                SET("id_date_out = #{id_date_out}");
            }
            if(borrow.getId_date_ret_plan()!=null){
                SET("id_date_ret_plan = #{id_date_ret_plan}");
            }
            if(borrow.getId_date_ret_act()!=null){
                SET("id_date_ret_act = #{id_date_ret_act}");
            }
            if(borrow.getId_over_day()!=null){
                SET("id_over_day = #{id_over_day}");
            }
            if(borrow.getId_over_money()!=null){
                SET("id_over_money = #{id_over_money}");
            }
            if(borrow.getId_punish_money()!=null){
                SET("id_punish_money = #{id_punish_money}");
            }
            if(borrow.is_has_return()){
                SET("is_has_return = 1");
            }
            WHERE("borrow_id = #{borrow_id}");
        }}.toString();
    }
}
