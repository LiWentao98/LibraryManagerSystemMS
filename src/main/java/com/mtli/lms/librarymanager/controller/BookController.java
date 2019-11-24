package com.mtli.lms.librarymanager.controller;


import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.model.BookCatelog;
import com.mtli.lms.librarymanager.service.impl.AdminServiceImpl;
import com.mtli.lms.librarymanager.service.impl.BookServiceImpl;
import com.mtli.lms.librarymanager.service.impl.CatelogServiceImpl;
import com.mtli.lms.librarymanager.service.impl.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description: 图书表示控制层
 * @Author: Mt.Li
*/

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceImpl bookService;
    @Autowired
    AdminServiceImpl adminService;
    @Autowired
    CatelogServiceImpl catelogService;
    @Autowired
    ReaderServiceImpl readerService;


    /**
     * 查询所有书籍种类(用于自动显示)
     * @return
     */
    @PostMapping("/find_all_book_category")
    @ResponseBody
    public List<BookCatelog> findAllBookCategory(){
        List<BookCatelog> bookCatelogs = catelogService.searchAllCatelogs();
        return bookCatelogs;
    }

    /**
     * 管理员根据分类号查询图书
     * @param model
     * @param pageNum
     * @param cId
     * @return
     */
    @GetMapping("show_books_result_page_by_category")
    public String showBooksResultPageByCategoryId(Model model, @RequestParam("pageNum") int pageNum, @RequestParam("c_id") int cId){
        List<Book> b = bookService.searchBookByConditionList(pageNum,cId);
        int count = bookService.searchBookCountByCatalog(cId);
        int pageCount = count/5;
        if(count%5 !=0){
            pageCount++;
        }
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageCount",pageCount);
        model.addAttribute("b",b);
        model.addAttribute("bookCategory",cId);
        return "admin/book/showBooks";
    }

    @PostMapping("/add_book_code")
    @ResponseBody
    public List<Book> addBookCode(){
        return bookService.searchBookLastCode();
    }

    /**
     * 管理员录入新书
     * @param book
     * @return
     */
    @PostMapping("/add_book")
    @ResponseBody
    public String addBook(Book book){
        Date date = new Date();
        book.setB_date_in(date);
        //设置在馆
        book.setB_status("在馆");
        Book book1 = book;
        boolean res=adminService.addBook(book1);
        if(res){
            return "true";
        }
        return "false";
    }

    /**
     * 管理员添加图书分类
     * @param bookCatelog
     * @return
     */
    @PostMapping("/add_book_category")
    @ResponseBody
    public String addBookCategory(BookCatelog bookCatelog){
        boolean res = catelogService.addCatelog(bookCatelog);
        if(res){
            return "true";
        }
        return "false";
    }

    /**
     * 管理员删除分类
     * @param cId
     * @return
     */
    @ResponseBody
    @PostMapping("/delete_category")
    public String deleteCategory(@RequestParam("categoryId" ) int cId){
        int res = catelogService.deleteCatelog(cId);
        if(res > 0){
            return "true";
        }
        return "false";
    }

    /**
     * 读者查询图书
     * @param model
     * @param bName
     * @param bAuthor
     * @param cId
     * @param bPress
     * @return
     */
    @PostMapping("/user_find_books")
    public String userFindBooks(Model model,@RequestParam(value = "bookName",required = false) String bName,
                                @RequestParam(value = "bookAuthor",required = false) String bAuthor,
                                @RequestParam(value = "c_id",required = false) Integer cId,
                                @RequestParam(value = "bookPress",required = false) String bPress,Book book){
        if (bName.length()!=0){
            book.setB_name(bName);
        }
        book.setB_catalog(cId);
        if(bAuthor.length()!=0){
            book.setB_author(bAuthor);
        }
        if(bPress.length()!=0){
            book.setB_press(bPress);
        }
        List<Book> b = readerService.searchBooks(book);
        model.addAttribute("b",b);
        return "user/findBook";
    }

    /**
     * 管理员借书查询图书
     * @param model
     * @param bName
     * @param book
     * @return
     */
    @PostMapping("/admin_find_books")
    public String AdminFindBooks(Model model,@RequestParam(value = "bookName",required = false) String bName,
                                 Book book){
        if (bName.length()!=0){
            book.setB_name(bName);
        }
        List<Book> b = readerService.searchBooks(book);
        model.addAttribute("b",b);
        return "admin/borrowBooks";
    }
}
