package com.mtli.lms.librarymanager.mapper.sql;

import com.mtli.lms.librarymanager.model.Admin;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-03 16:32
 */
public class AdminSqlProvider {
    public String selectAdmin(Admin admin){
        return new SQL (){{
            SELECT("*");
            FROM("Admin");
            if(admin.getUsername() !=null){
                WHERE("username = #{username}");
            }
        }}.toString();
    }
}
