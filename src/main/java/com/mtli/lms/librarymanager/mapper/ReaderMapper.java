package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.ReaderSqlProvider;
import com.mtli.lms.librarymanager.model.Reader;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 读者数据操作
 * @Author: Mt.Li
*/

@Repository
public interface ReaderMapper {
    //新增读者
    @InsertProvider(type = ReaderSqlProvider.class,method = "insertReader")
    int insert(Reader reader);
    //删除读者
    @DeleteProvider(type = ReaderSqlProvider.class,method = "deleteReader")
    int delete(Integer r_id);
    //修改读者信息
    @UpdateProvider(type = ReaderSqlProvider.class,method = "editReader")
    int edit(Reader reader);
    //根据读者id查询读者信息
    @SelectProvider(type = ReaderSqlProvider.class,method = "selectReader")
    List<Reader> selectReader(Reader reader);
    //根据读者id查询读者信息
    @Select("select * from reader where r_id = #{r_id}")
    Reader selectJReader(Integer r_id);
    //查询所有读者数量
    @Select("select count(r_id) from reader")
    Integer searchCount();
    //根据读者类型所属单位和姓名查询读者
    @Select("select * from reader where r_type = #{r_type} and r_dept = #{r_dept} and r_name = #{r_name}")
    List<Reader> selectNewReader(Reader reader);
    //查询读者已经借的数量
    @Select("select r_borrow_q from reader where r_id = #{r_id}")
    int searchBorrowQ(Integer r_id);

}
