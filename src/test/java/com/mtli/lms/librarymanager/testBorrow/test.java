//package com.mtli.lms.librarymanager.testBorrow;
//
//import com.mtli.lms.librarymanager.mapper.BorrowMapper;
//import com.mtli.lms.librarymanager.model.Borrow;
//import com.mtli.lms.librarymanager.service.impl.ReaderServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @Description:
// * @Author: Mt.Li
// * @Create: 2019-11-16 13:33
// */
//@Controller
//@RequestMapping("/test")
//public class test {
//    @Autowired
//    private ReaderServiceImpl readerService;
//
//    @PostMapping("/test1")
//    @ResponseBody
//    public String test(@RequestParam("b_id") Integer b_id,@RequestParam("r_id") Integer r_id){
//        boolean res = readerService.reserveBorrowBook(b_id,r_id);
//        if(res){
//            return "true";
//        }
//        return "false";
//    }
//}
