package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.ReaderType;
import org.springframework.stereotype.Service;

/**
 * @Description: 读者类型管理业务，实现插、删、改、查等信息维护操作
 * @Author: Mt.Li
*/
@Service
public interface ReaderTypeService {
    //查询读者类型信息（根据读者id）
    ReaderType searchMessage(Integer id);
}
