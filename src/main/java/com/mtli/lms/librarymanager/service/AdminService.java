package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.Admin;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Borrow;
import com.mtli.lms.librarymanager.model.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    //管理员登录时查询管理员
    boolean searchAdmin(Admin admin);
    //查询用户(分页)
    List<Reader> searchReaderList(int pageNum);
    //添加书籍
    public boolean addBook(Book book);
    //添加用户
    boolean addUser(Reader reader);
    //增加图书类别
    public boolean addBookCategory(String bookCategory);
    //根据读者id查询读者信息
    public List<Reader> searchUserById(Reader reader);
    //更新用户信息
    public boolean updateUser(Reader reader);
    //查询用户状态
    public String searchUserStatus(Integer r_id);
    //查询所有预约单数量
    int searchReserveCountByAdmin();
    //更新预约单
    boolean updateReserveBorrow(Borrow borrow);
    //增加对应天数
    int addDays(Integer r_id);
    //管理员查询所有未还书借阅单
    List<Borrow> searchNoReturnBorrows(Integer pageNum);
    //管理员查询所有未归还借阅单数量
    int searchNoReturnBorrowCount();
    //管理员查询读者未归还的借阅单
    List<Borrow> searchNoReturnBorrowsByReader(Integer pageNum,Integer rId);
    //管理员查询读者所有未归还借阅单数量
    int searchNoReturnBorrowCountByReader(Integer rId);
    //管理员查询所有归还的借书单
    List<Borrow> searchReturnBorrows(Integer pageNum);
    //管理员查询所有归还借阅单数量
    int searchReturnBorrowCount();
    //续借时更新借阅单
    boolean updateBorrowList(Borrow borrow);
    //根据borrowId查询借书单
    Borrow searchBorrowByBorrowId(Integer borrowId);
}
