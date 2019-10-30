package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.model.ReaderType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 读者类型数据操作
 * @Author: Mt.Li
*/
@Repository
public interface ReaderTypeMapper {
    //添加读者类型
    void addReaderType(ReaderType readerType);
    //删除读者类型
    void deleteReaderType(Integer id);
    //修改读者类型
    void editReaderType(ReaderType readerType);
    //查询读者类型
    List<ReaderType> selectReaderType(Integer id);
}
