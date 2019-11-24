package com.mtli.lms.librarymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtli.lms.librarymanager.mapper.AdminMapper;
import com.mtli.lms.librarymanager.mapper.BookMapper;
import com.mtli.lms.librarymanager.mapper.BorrowMapper;
import com.mtli.lms.librarymanager.mapper.ReaderMapper;
import com.mtli.lms.librarymanager.model.Admin;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Borrow;
import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-03 15:24
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ReaderMapper readerMapper;
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public boolean searchAdmin(Admin admin) {
        if(admin.getUsername() !=null){
            List<Admin> admin1 = adminMapper.searchAdmin(admin);
            if(admin == null){
                return false;
            }
            for(Admin a:admin1){
                if(a.getPassword().equals(admin.getPassword())){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public List<Reader> searchReaderList(int pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Reader> readerList = adminMapper.searchReaders();
        //传入要分页的结果对象
        PageInfo<Reader> readerPageInfo = new PageInfo<>(readerList);
        //得到分页中的Question条目对象
        List<Reader> pageList = readerPageInfo.getList();

        return pageList;
    }

    @Override
    public boolean addBook(Book book) {
        int n=bookMapper.addBook(book);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(Reader reader) {
        int res = readerMapper.insert(reader);
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean addBookCategory(String bookCategory) {
        return false;
    }

    @Override
    public List<Reader> searchUserById(Reader reader) {
        return readerMapper.selectReader(reader);
    }

    @Override
    public boolean updateUser(Reader reader) {
        int n = readerMapper.edit(reader);
        if(n!=0){
            return true;
        }
        return false;
    }

    @Override
    public String searchUserStatus(Integer r_id) {
        return adminMapper.searchReaderStatus(r_id);
    }

    @Override
    public int searchReserveCountByAdmin() {
        return borrowMapper.searchReserveCountByAdmin();
    }

    @Override
    public boolean updateReserveBorrow(Borrow borrow) {
        int n = borrowMapper.updateBorrow(borrow);
        if(n!=0){
            return true;
        }
        return false;
    }

    @Override
    public int addDays(Integer r_id) {
        int n = readerMapper.selectJReader(r_id).getR_type();
        if(n!=40){
            return 30;
        }
        return 60;
    }
    @Override
    public List<Borrow> searchNoReturnBorrows(Integer pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchNoReturnBorrow();
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Borrow条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }

    @Override
    public int searchNoReturnBorrowCount() {
        return borrowMapper.getNoReturnBorrowCount();
    }

    @Override
    public List<Borrow> searchNoReturnBorrowsByReader(Integer pageNum,Integer rId) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchNoReturnBorrowByReader(rId);
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Borrow条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }

    @Override
    public int searchNoReturnBorrowCountByReader(Integer rId) {
        return borrowMapper.getNoReturnBorrowCountByReader(rId);
    }

    @Override
    public List<Borrow> searchReturnBorrows(Integer pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchReturnBorrow();
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Borrow条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }

    @Override
    public int searchReturnBorrowCount() {
        return borrowMapper.getReturnBorrowCount();
    }

    @Override
    public boolean updateBorrowList(Borrow borrow) {
        int n = borrowMapper.updateBorrow(borrow);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public Borrow searchBorrowByBorrowId(Integer borrowId) {
        return borrowMapper.searchBorrowByBorrowId(borrowId);
    }
}
