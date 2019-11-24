package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 读者管理业务，实现借书证办理、变更、补办、挂失、解除挂失、注销等用例中的各种系统操作
 * @Author: Mt.Li
*/
@Service
public interface ReaderService {
    //读者添加业务
    int add(Reader reader);
    //读者 信息删除业务
    int delete(Integer r_id);
    //读者信息更新业务
    boolean updateUser(Reader reader);
    //读者信息查询业务
    Reader select(Reader reader);
    //读者登录时查询读者
    Reader searchReader(Reader reader);
    //查询读者人数
    Integer searchCount();
    //查询需要新建借书证的读者信息
    List<Reader> searchNewReader(Reader reader);
    //读者查询书籍
    List<Book> searchBooks(Book book);
    //查询读者姓名
    String searchName(Integer r_id);
    //查询读者借书数量
    int searchBorrowQ(Integer r_id);
    //单纯查询用户信息
    Reader searchJReader(Integer r_id);


}
