package com.mtli.lms.librarymanager.controller;

import com.mtli.lms.librarymanager.model.Reader;
import com.mtli.lms.librarymanager.service.impl.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("readerController")
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    ReaderServiceImpl readerService;

    @ResponseBody
    @PostMapping("/add_reader")
    public void addReader(@RequestParam(value = "r_photo",required=false) String rPhoto ,@RequestBody Reader reader){
        byte[] photo = rPhoto.getBytes();
        reader.setR_photo(photo);
        readerService.add(reader);
    }

    @ResponseBody
    @DeleteMapping("/delete_reader")
    public void deleteReader(@RequestBody Reader reader){
        readerService.delete(reader);
    }

    @ResponseBody
    @PutMapping("/update_reader")
    public void updateReader(@RequestParam(value = "r_photo",required=false) String rPhoto,@RequestBody Reader reader){
        byte[] photo = rPhoto.getBytes();
        reader.setR_photo(photo);
        readerService.update(reader);
    }

    @ResponseBody
    @GetMapping("/select_reader/{id}")
    public List<Reader> selectReader(@PathVariable Integer id){
        Reader reader = new Reader();
        reader.setR_id(id);
        return readerService.select(reader);
    }

    //测试controller
    @ResponseBody
    @GetMapping("/add_new")
    public String addNew(){
        return "index.html";
    }

}
