package com.mtli.lms.librarymanager.service;

import com.mtli.lms.librarymanager.model.Borrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowService {
    //添加预约借书单
    boolean addBorrow(Borrow borrow);
    //查询该读者的所有预约单
    List<Borrow> searchReserveBorrowList(Integer r_id, Integer pageNum);
    //查询管理员批注的所有借阅单
    List<Borrow> searchBorrowListByAdmin(Integer r_id, Integer pageNum);
    //查询预约借书单的数量
    int searchReserveCount(Integer r_id);
    //查询借书单的数量
    int searchAdminBorrowsCount(Integer r_id);
    //管理员查询所有的预约单
    List<Borrow> searchAllBorrowsByAdmin(Integer pageNum);
}
