package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {
    @Resource
    BookService bookService;

    @RequestMapping("book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        System.out.println("Hello,Book-Service");
        return bookService.getBookById(bid);
    }

    @RequestMapping("/book/remain/{uid}")
    public int bookRemain(@PathVariable("uid") int uid){
        return bookService.getRemain(uid);
    }

    @RequestMapping("/book/borrow/{uid}")
    public boolean bookBorrow(@PathVariable("uid") int uid){
        int remain = bookService.getRemain(uid);
        return bookService.setRemain(uid, remain - 1);
    }
}
