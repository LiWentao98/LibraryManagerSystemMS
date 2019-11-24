package com.mtli.lms.librarymanager.controller;

import com.mtli.lms.librarymanager.model.*;
import com.mtli.lms.librarymanager.service.impl.*;
import com.mtli.lms.librarymanager.util.ReaderUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Description:
 * @Author: Mt.Li
 * @Create: 2019-11-03 13:25
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    //引入资源
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    ReaderServiceImpl readerService;
    @Autowired
    CatelogServiceImpl catelogService;
    @Autowired
    ReaderTypeServiceImpl readerTypeService;
    @Autowired
    BorrowServiceImpl borrowService;
    @Autowired
    BookServiceImpl bookService;

    //私有对象
    private Date date = new Date();
    private Borrow borrow = new Borrow();
    private Reader reader = new Reader();
    private Admin admin = new Admin();
    private Book book = new Book();
    private ReaderUtil readerUtil= new ReaderUtil();
    private ReaderType readerType = new ReaderType();

    /**
     * 管理员去登录
     * @return
     */
    @GetMapping("/to_login")
    public String toLogin(){
        return "adminLogin";
    }

    /**
     * 管理员登录
     * @param adminName
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/adminLogin")
    public String adminLogin(@Param("adminName") String adminName,@Param("password") String password, HttpServletRequest request){
        admin.setUsername(adminName);
        admin.setPassword(password);
        boolean res = adminService.searchAdmin(admin);
        if(res==false) {
            return "adminLogin";
        }
        request.getSession().setAttribute("reader",admin);
        return "admin/index";
    }

    /**
     * 管理员登录
     * @param request
     * @return
     */
    @RequestMapping("/adminLogOut")
    public String adminLogOut(HttpServletRequest request){
        //清除所有session信息
        request.getSession().invalidate();
        return "adminLogin";
    }

    /**
     * 管理员去添加书籍（控制器转bookController）
     * @return
     */
    @GetMapping("/to_addBook")
    public String toAddBook(){
        return "admin/book/addBook";
    }

    /**
     * 管理员查看所有用户
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/show_users")
    public String showUsersPage(Model model, @RequestParam("pageNum") int pageNum){
        List<Reader> r = adminService.searchReaderList(pageNum);
        int count = readerService.searchCount();
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("r",r);
        return "admin/reader/showUsers";
    }

    /**
     * 根据条件查询书籍
     * @return
     */
    @GetMapping("/to_show_books")
    public String toShowBooks(){
        return "admin/book/searchBooksConditions";
    }

    /**
     * 去添加书籍
     * @return
     */
    @GetMapping("/to_add_books")
    public String toAddBooks(){
        return "admin/book/addBook";
    }

    /**
     * 去添加分类号
     * @return
     */
    @GetMapping("/to_add_category")
    public String toAddCategory(){
        return "admin/category/addCategory";
    }

    /**
     * 管理员查询所有分类号
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/show_catelogs")
    public String showCatelogs(Model model,@RequestParam("pageNum") int pageNum){
        List<BookCatelog> bookCatelogList = catelogService.getBookCatelogList(pageNum);
        int count = catelogService.getCatelogCount();
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("c",bookCatelogList);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        return "admin/category/showCategorys";
    }

    /**
     * 添加新用户前先去查询是否存在
     * @return
     */
    @GetMapping("/to_search_new_user")
    public String toSearchNewUser(){
        return "admin/reader/addAndSearchUser";
    }

    /**
     * 查询新用户是否存在，存在就不新建
     * @param model
     * @param rType
     * @param rDept
     * @param rName
     * @return
     */
    @GetMapping("/search_new_user")
    public String toAddAndSearch(Model model,@RequestParam("rType") String rType,
                                 @RequestParam("rDept") String rDept,
                                 @RequestParam("rName") String rName){
        reader.setR_type(readerUtil.readerTypeChange(rType));
        reader.setR_dept(rDept);
        reader.setR_name(rName);
        List<Reader> reader1 = readerService.searchNewReader(reader);
        for(Reader r:reader1){
            if(r.getR_name()!=null){
                model.addAttribute("r",reader1);
                return "admin/reader/searchNewUser";
            }
        }
        model.addAttribute("data","查不到该用户，请添加用户！");
        return "admin/reader/addUser";
    }

    /**
     * 新添读者
     * @param
     * @return
     */
    @PostMapping("/add_user")
    public void addUser(Reader reader, HttpServletResponse response){
        reader.setR_status("有效");
        boolean res = adminService.addUser(reader);
        try {
            PrintWriter writer = response.getWriter();
            String msg = null;
            if(res){
                msg = "alert( 'add success' );location.href='/reader/to_login'";
            }else {
                msg = "alert('add defeat');history.go(-1)";
            }
            writer.print("<script>" + msg + "</script>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 去新添分类号
     * @return
     */
    @GetMapping("/to_add_catelog")
    public String toAddCatelog(){
        return "admin/category/addCategory";
    }

    /**
     * 去修改读者
     * @return
     */
    @GetMapping("/to_edit_user")
    public String toEditUser(){
        return "admin/reader/editUser";
    }

    /**
     * 修改读者
     * @param reader
     * @return
     */
    @PostMapping("/edit_user")
    @ResponseBody
    public String editUser(Reader reader){
        boolean res = readerService.updateUser(reader);
        if(res){
            return "true";
        }
        return "false";
    }

    /**
     * 去修改借书证状态
     * @return
     */
    @GetMapping("/to_edit_rId")
    public String toEditRId(){
        return "admin/reader/editRId";
    }

    /**
     * 修改借书证前先查询读者
     * @param model
     * @param rId
     * @param rType
     * @param rDept
     * @param rName
     * @return
     */
    @PostMapping("/edit_rId_to_search")
    public String editRIdToSearch(Model model,@RequestParam(value = "r_id",required = false) Integer rId,
                          @RequestParam(value = "r_type",required = false) String rType,
                          @RequestParam(value = "r_dept",required = false) String rDept,
                          @RequestParam(value = "r_dept",required = false) String rName){
        if(rId!=null){
            reader.setR_id(rId);
            List<Reader> r = adminService.searchUserById(reader);
            model.addAttribute("r",r);
        }else if(rType!=null && rDept!=null && rName!=null){
            reader.setR_type(readerUtil.readerTypeChange(rType));
            reader.setR_dept(rDept);
            reader.setR_name(rName);
            List<Reader> r = readerService.searchNewReader(reader);
            model.addAttribute("r",r);
        }
        return "admin/reader/editRId";
    }

    /**
     * 挂失借书证
     * @param rId
     * @param reader
     * @return
     */
    @PostMapping("/close_voucher")
    @ResponseBody
    public String closeVoucher(@RequestParam("r_id") Integer rId,Reader reader){
        String rSta = adminService.searchUserStatus(rId);
        if(rSta.equals("挂失")){
            return "false";
        }
        reader.setR_id(rId);
        reader.setR_status("挂失");
        boolean res = adminService.updateUser(reader);
        if(res){
            return "true";
        }
        return "false";
    }

    /**
     * 解除挂失
     * @param rId
     * @param reader
     * @return
     */
    @PostMapping("/relieve_close_voucher")
    @ResponseBody
    public String relieveCloseVoucher(@RequestParam("r_id") Integer rId, Reader reader ){
        String rSta = adminService.searchUserStatus(rId);
        if(rSta.equals("有效")){
            return "false";
        }
        reader.setR_id(rId);
        reader.setR_status("有效");
        boolean res = adminService.updateUser(reader);
        if(res){
            return "true";
        }
        return "false";
    }

    @GetMapping("/to_borrow_books")
    public String toBorrowBooks(){
        return "admin/borrowBooks";
    }

    /**
     * 管理员操作借书
     * @param rId
     * @param bId
     * @param bName
     * @param bAuthor
     * @return
     */
    @PostMapping("/borrows_books")
    @ResponseBody
    public String borrowBooks(@RequestParam("rId") Integer rId,@RequestParam("bId") Integer bId,
                              @RequestParam(value = "bName",required = false) String bName,@RequestParam(value = "bAuthor",required = false) String bAuthor){
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 30);// num为增加的天数，可以改变的

        Reader reader1 = readerService.searchJReader(rId);

        borrow.setB_id(bId);
        borrow.setR_id(rId);
        borrow.setId_date_out(date);
        borrow.setId_date_ret_plan(ca.getTime());
        borrow.setB_author(bAuthor);
        borrow.setB_name(bName);
        borrow.setR_name(readerService.searchJReader(rId).getR_name());

        reader.setR_id(rId);
        if(reader1.getR_borrow_q()<readerTypeService.searchMessage(reader1.getR_type()).getC_lend_q() && reader1.getR_status().equals("有效")){//可以借书
            boolean res = borrowService.addBorrow(borrow);
            if(res){
                reader.setR_borrow_q(reader1.getR_borrow_q()+1);
                readerService.updateUser(reader);
                book.setB_repertory(bookService.searchBookByBId(bId).getB_repertory()-1);
                book.setB_id(bId);
                bookService.update(book);
                return "true";
            }
            return "false";
        }
        return"false";
    }

    /**管理员显示所有预约单
     * 显示
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/solve_reserve")
    public String solveReserve(Model model,@RequestParam("pageNum") Integer pageNum){
        List<Borrow> b = borrowService.searchAllBorrowsByAdmin(pageNum);
        int count = adminService.searchReserveCountByAdmin();
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "admin/borrowBook/solveReserve";
    }

    /**
     * 处理预约单
     * @param borrowId
     * @param rId
     * @return
     */
    @PostMapping("/to_solve_reserve")
    @ResponseBody
    public String toSolveReserve(@RequestParam("borrowId") Integer borrowId,
                                 @RequestParam("rId") Integer rId){
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, adminService.addDays(rId));// num为增加的天数，可以改变的

        Reader reader1 = readerService.searchJReader(rId);
        ReaderType readerType = readerTypeService.searchMessage(reader1.getR_type());
        borrow.setBorrow_id(borrowId);
        borrow.setId_date_out(date);
        borrow.setId_date_ret_plan(ca.getTime());

        reader.setR_id(rId);
        if(readerService.searchBorrowQ(rId)<readerType.getC_lend_q() && reader1.getR_status().equals("有效")){//可以预约
            boolean res = adminService.updateReserveBorrow(borrow);
            if(res){
                reader.setR_borrow_q(reader1.getR_borrow_q()+1);
                readerService.updateUser(reader);
                return "true";
            }
            return "false";
        }
        return "false";
    }

    /**
     * 查询未归还图书的借阅单
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/look_borrows_no_return")
    public String lookBorrowsNoReturn(Model model,@RequestParam("pageNum") Integer pageNum){
        //获取分页查询结果
        List<Borrow> b = adminService.searchNoReturnBorrows(pageNum);
        int count = adminService.searchNoReturnBorrowCount();
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "admin/borrowBook/lookNoReturnBorrows";
    }

    /**
     * 还书操作
     * @param borrowId
     * @return
     */
    @PostMapping("/return_book")
    @ResponseBody
    public String returnBook(@RequestParam("borrowId") Integer borrowId){
        Date date = new Date();
        Borrow borrow1 = adminService.searchBorrowByBorrowId(borrowId);
        Reader reader1 = readerService.searchJReader(borrow1.getR_id());
        reader1.setR_borrow_q(reader1.getR_borrow_q()-1);
        Book book1 = bookService.searchBookByBId(borrow1.getB_id());
        book1.setB_repertory(book1.getB_repertory()+1);
        bookService.update(book1);
        borrow.setBorrow_id(borrowId);
        borrow.set_has_return(true);
        borrow.setId_date_ret_act(date);
        //差超期天数

        if(adminService.updateReserveBorrow(borrow)){
            readerService.updateUser(reader1);
            return "true";
        }
        return "false";
    }

    /**
     * 查询未归还图书的借阅单
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/look_borrows_return")
    public String lookBorrowsReturn(Model model,@RequestParam("pageNum") Integer pageNum){
        //获取分页查询结果
        List<Borrow> b = adminService.searchReturnBorrows(pageNum);
        int count = adminService.searchReturnBorrowCount();
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "admin/borrowBook/lookReturnBorrows";
    }

    /**
     * 去续借
     * @return
     */
    @GetMapping("/to_continue_book")
    public String toContinueBook(){
        return "admin/borrowBook/continueBookSearch";
    }

    /**
     * 续借前查询
     * @param rId
     * @param pageNum
     * @param model
     * @return
     */
    @PostMapping("/continue_book_search")
    public String continueBookSearch(@RequestParam("rId") Integer rId,
                                     @RequestParam("pageNum") Integer pageNum,Model model){
        //获取分页查询结果
        List<Borrow> b = adminService.searchNoReturnBorrowsByReader(pageNum,rId);
        int count = adminService.searchNoReturnBorrowCountByReader(rId);
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "admin/borrowBook/continueBook";
    }

    /**
     * 续借
     * @param borrowId
     * @param rId
     * @param bCT 续借次数
     * @return
     */
    @PostMapping("/continue_book")
    @ResponseBody
    public String continueBook(@RequestParam("borrowId") Integer borrowId,@RequestParam("rId") Integer rId,@RequestParam("bCT") Integer bCT){
        borrow = adminService.searchBorrowByBorrowId(borrowId);
        reader = readerService.searchJReader(rId);
        readerType = readerTypeService.searchMessage(reader.getR_type());
        if(bCT<readerType.getC_lend_q() && reader.getR_status().equals("有效") && borrow.getId_continue_times()<readerTypeService.searchMessage(reader.getR_type()).getC_continue_times()){
            //增加续借数
            borrow.setId_continue_times(bCT+1);
            //更改应还日期
            Calendar c = Calendar.getInstance();
            c.setTime(borrow.getId_date_ret_plan());
            c.add(5,adminService.addDays(rId));
            borrow.setId_date_ret_plan(c.getTime());
            if(adminService.updateBorrowList(borrow)){
                return "true";
            }
            return "false";
        }
        return "false";
    }

}
