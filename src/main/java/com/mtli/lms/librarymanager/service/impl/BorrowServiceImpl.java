package com.mtli.lms.librarymanager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mtli.lms.librarymanager.mapper.BorrowMapper;
import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Borrow;
import com.mtli.lms.librarymanager.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-16 16:34
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public boolean addBorrow(Borrow borrow) {
        int n = borrowMapper.addBorrow(borrow);
        if(n>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Borrow> searchReserveBorrowList(Integer r_id, Integer pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchReserveBorrowList(r_id);
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Question条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }

    @Override
    public List<Borrow> searchBorrowListByAdmin(Integer r_id, Integer pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchBorrowListByAdmin(r_id);
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Question条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }

    @Override
    public int searchReserveCount(Integer r_id) {
        return borrowMapper.searchReserveCount(r_id);
    }

    @Override
    public int searchAdminBorrowsCount(Integer r_id) {
        return borrowMapper.searchAdminBorrowsCount(r_id);
    }

    @Override
    public List<Borrow> searchAllBorrowsByAdmin(Integer pageNum) {
        //设置起始点
        PageHelper.startPage(pageNum,5);
        //获取结果集
        List<Borrow> borrowList = borrowMapper.searchAllReserveBorrowListByAdmin();
        //传入要分页的结果对象
        PageInfo<Borrow> borrowPageInfo = new PageInfo<>(borrowList);
        //得到分页中的Borrow条目对象
        List<Borrow> pageList = borrowPageInfo.getList();
        return pageList;
    }


}
