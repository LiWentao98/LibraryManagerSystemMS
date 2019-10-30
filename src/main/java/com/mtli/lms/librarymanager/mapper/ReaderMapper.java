package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.ReaderSqlProvider;
import com.mtli.lms.librarymanager.model.Reader;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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
    public void insert(Reader reader);
    //删除读者
    @DeleteProvider(type = ReaderSqlProvider.class,method = "deleteReader")
    public void delete(Reader reader);
    //修改读者信息
    @UpdateProvider(type = ReaderSqlProvider.class,method = "editReader")
    public void edit(Reader reader);
    //根据读者id查询读者信息
    @SelectProvider(type = ReaderSqlProvider.class,method = "selectReader")
    public List<Reader> selectReader(Reader reader);
}
