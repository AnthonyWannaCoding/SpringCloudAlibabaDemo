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

    @Override
    public boolean setRemain(int bid, int count) {
        return mapper.setRemain(bid, count) > 0;
    }

    @Override
    public int getRemain(int bid) {
        return mapper.getRemain(bid);
    }
}
