package com.mtli.lms.librarymanager.controller;

import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.Borrow;
import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.model.ReaderType;
import com.mtli.lms.librarymanager.service.impl.BookServiceImpl;
import com.mtli.lms.librarymanager.service.impl.BorrowServiceImpl;
import com.mtli.lms.librarymanager.service.impl.ReaderServiceImpl;
import com.mtli.lms.librarymanager.service.impl.ReaderTypeServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reader")
public class UserController {
    @Autowired
    ReaderServiceImpl readerService;
    @Autowired
    ReaderTypeServiceImpl readerTypeService;
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    BorrowServiceImpl borrowService;

    private Map<String,String> msg = new HashMap<>();

    @ResponseBody
    @PostMapping("/add_reader")
    public void addReader(@RequestParam(value = "r_photo",required=false) String rPhoto ,@RequestBody Reader reader){
        byte[] photo = rPhoto.getBytes();
        reader.setR_photo(photo);
        readerService.add(reader);
    }

    @ResponseBody
    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam("userId") int r_id){
        int res = readerService.delete(r_id);
        if(res > 0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("/to_update_reader")
    public String toUpdateUser(){
        return "user/changeReaderMessage";
    }

    @PostMapping("/update_reader")
    public String updateReader(@Param("r_pwd") String r_pwd,
                              HttpServletRequest request){
        Reader reader = (Reader)request.getSession().getAttribute("reader");
        Reader reader1 = new Reader();
        reader1.setR_id(reader.getR_id());
        reader1.setR_pwd(r_pwd);
        //reader1.setR_phone(r_phone);
        boolean res = readerService.updateUser(reader1);
        if(res){
            request.getSession().invalidate();
            return "index";
        }
        return "user/changeReaderMessage";
    }

    @RequestMapping("/to_login")
    public String toLogin(){
        return "index";
    }

    @PostMapping("/userLogin")
    public String userLogin(@RequestParam("cardNumber") Integer cardNumber,
                            @RequestParam("password") String password, HttpServletRequest request){
        Reader reader = new Reader();
        reader.setR_id(cardNumber);
        reader.setR_pwd(password);
        Reader reader1 = readerService.searchReader(reader);
        if(reader1.getR_name()!=null){
            request.getSession().setAttribute("reader",reader1);
            return "user/index";
        }
        return "index";
    }

    @GetMapping("/to_index")
    public String toIndex(){
        return "user/index";
    }

    @RequestMapping("/userLogOut")
    public String userLogOut(HttpServletRequest request){
        //清除所有session信息
        request.getSession().invalidate();
        return "index";
    }

    @GetMapping("/user_message")
    public String userMessage(){
        return "user/userMessage";
    }

    /**
     * 用户点击查询书籍按钮
     * @return
     */
    @GetMapping("/to_find_book")
    public String toFindBook(){
        return "user/findBook";
    }

    /**
     * 读者预约借书
     * @param request
     * @param bId
     * @param bName
     * @param bAuthor
     * @return
     */
    @PostMapping("/reserve_borrow_book")
    @ResponseBody
    public String reserveBorrowBook(HttpServletRequest request,@RequestParam("bId") Integer bId,@RequestParam("bName") String bName,
                                    @RequestParam("bAuthor") String bAuthor){
        Borrow borrow = new Borrow();
        Book book = new Book();
        borrow.setB_id(bId);
        //获取session中的readerid,并赋给borrow
        Reader reader = (Reader)request.getSession().getAttribute("reader");
        Reader reader1 = readerService.searchJReader(reader.getR_id());
        ReaderType readerType = readerTypeService.searchMessage(reader.getR_type());
        borrow.setR_id(reader.getR_id());
        borrow.setId_continue_times(0);
        borrow.setB_name(bName);
        borrow.setR_name(reader.getR_name());
        borrow.setB_author(bAuthor);
        //判断该读者能否借书
        if(reader.getR_borrow_q()<readerType.getC_lend_q() && reader.getR_status().equals("有效")){//可以预约
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
        return "false";
    }

    /**
     * 跳转到查看用户预约书单页面
     * @return
     */
    @GetMapping("/look_reserve_borrows")
    public String LookReserveBorrows(Model model, @RequestParam("pageNum") int pageNum, HttpServletRequest request){
        //获取session中的reader
        Reader reader = (Reader)request.getSession().getAttribute("reader");
        //获取分页查询结果
        List<Borrow> b = borrowService.searchReserveBorrowList(reader.getR_id(),pageNum);
        int count = borrowService.searchReserveCount(reader.getR_id());
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "user/borrowingBooksRecordByUser";
    }

    /**
     * 跳转到查看用户已经办理的借书记录
     * @return
     */
    @GetMapping("/look_admin_borrows")
    public String LookAdminBorrows(Model model, @RequestParam("pageNum") int pageNum, HttpServletRequest request){
        //获取session中的reader
        Reader reader = (Reader)request.getSession().getAttribute("reader");
        //获取分页查询结果
        List<Borrow> b = borrowService.searchBorrowListByAdmin(reader.getR_id(),pageNum);
        int count = borrowService.searchAdminBorrowsCount(reader.getR_id());
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        return "user/borrowingBooksRecordByAdmin";
    }
}
