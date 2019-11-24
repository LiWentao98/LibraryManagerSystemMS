package com.mtli.lms.librarymanager.mapper;

import com.mtli.lms.librarymanager.mapper.sql.BorrowSqlProvider;
import com.mtli.lms.librarymanager.model.Borrow;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowMapper {
    //添加预约借书单
    @InsertProvider(type = BorrowSqlProvider.class,method = "addBorrow")
    int addBorrow(Borrow borrow);
    //查询所有预约单（通过读者id）
    @Select("select * from borrow where r_id = #{r_id} and id_date_out is null")
    List<Borrow> searchReserveBorrowList(Integer r_id);
    //查询所有预约单
    @Select("select * from borrow where id_date_out is null")
    List<Borrow> searchAllReserveBorrowListByAdmin();
    //查询所有管理员批准的单
    @Select("select * from borrow where r_id = #{r_id} and id_date_out is not null")
    List<Borrow> searchBorrowListByAdmin(Integer r_id);
    //查询预约单的数量（读者）
    @Select("select count(#{r_id}) from borrow where r_id = #{r_id} and id_date_out is null")
    int searchReserveCount(Integer r_id);
    //查询借阅单的数量（读者）
    @Select("select count(#{r_id}) from borrow where r_id = #{r_id} and id_date_out is not null")
    int searchAdminBorrowsCount(Integer r_id);
    //查询所有预约单数量（admin）
    @Select("select count(b_id) from borrow where id_date_out is null")
    int searchReserveCountByAdmin();
    //更新单子
    @UpdateProvider(type = BorrowSqlProvider.class,method = "updateBorrow")
    int updateBorrow(Borrow borrow);
    //查询所有未还书的借阅单
    @Select("select * from borrow where id_date_out is not null and is_has_return = 0")
    List<Borrow> searchNoReturnBorrow();
    //查询未还书的借阅单数量
    @Select("call getNoReturnBorrowCount")
    int getNoReturnBorrowCount();
    //查询所有还书的借阅单
    @Select("select * from borrow where id_date_out is not null and is_has_return = 1")
    List<Borrow> searchReturnBorrow();
    //查询还书的借阅单数量
    @Select("call getReturnBorrowCount")
    int getReturnBorrowCount();
    //查询读者没有归还的借阅单
    @Select("select * from borrow where r_id = #{rId} and id_date_out is not null and is_has_return = 0")
    List<Borrow> searchNoReturnBorrowByReader(Integer rId);
    //查询读者未还书的借阅单数量
    @Select("select count(borrow_id) from borrow where r_id = #{rId} and id_date_out is not null and is_has_return = 0")
    int getNoReturnBorrowCountByReader(Integer rId);
    //根据借阅单号查询借阅单
    @Select("select * from borrow where borrow_id = #{borrowId}")
    Borrow searchBorrowByBorrowId(Integer borrowId);
}
