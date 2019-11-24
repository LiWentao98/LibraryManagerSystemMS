package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.AdminSqlProvider;
import com.mtli.lms.librarymanager.model.Admin;
import com.mtli.lms.librarymanager.model.Reader;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-03 16:31
 */
@Repository
public interface AdminMapper {
    //根据用户名查询管理员
    @SelectProvider(type = AdminSqlProvider.class,method = "selectAdmin")
    public List<Admin> searchAdmin(Admin admin);
    //查询用户(所有)
    @Select("select * from reader")
    public List<Reader> searchReaders();
    //查询用户状态
    @Select("select r_status from reader where r_id = #{r_id}")
    public String searchReaderStatus(Integer r_id);
}
