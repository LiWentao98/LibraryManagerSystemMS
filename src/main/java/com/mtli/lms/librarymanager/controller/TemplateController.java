package com.mtli.lms.librarymanager.controller;

import com.mtli.lms.librarymanager.model.Book;
import com.mtli.lms.librarymanager.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource
    BookServiceImpl bookService;

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {

        List<Book> books = bookService.selectAllBook();

        Map<String,String> user = new HashMap<>();

        user.put("id","1");
        user.put("username","liwentao");
        user.put("password","123456");

        model.addAttribute("books", books);

        model.addAttribute("user", user);

        //模版名称，实际的目录为：resources/templates/thymeleaftemp.html
        return "thymeleaftemp";
    }
}