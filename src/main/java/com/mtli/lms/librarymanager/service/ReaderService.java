package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 读者管理业务，实现借书证办理、变更、补办、挂失、解除挂失、注销等用例中的各种系统操作
 * @Author: Mt.Li
*/

public interface ReaderService {
    //读者添加业务
    void add(Reader reader);
    //读者 信息删除业务
    void delete(Reader reader);
    //读者信息更新业务
    void update(Reader reader);
    //读者信息查询业务
    List<Reader> select(Reader reader);

}
