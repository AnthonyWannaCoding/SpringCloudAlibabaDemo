package com.example.service.impl;

import com.example.Mapper.BookMapper;
import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}
