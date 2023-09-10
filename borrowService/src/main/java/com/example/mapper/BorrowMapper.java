package com.example.mapper;

import com.example.entity.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("Select * from DB_BORROW where uid=#{uid}")
    List<Borrow> getBorrowByUid(int uid);

    @Select("Select * from DB_BORROW where bid=#{bid}")
    List<Borrow> getBorrowByBid(int bid);

    @Select("Select * from DB_BORROW where bid=#{bid} and uid=#{uid}")
    Borrow getBorrow(int uid,int bid);

    @Insert("insert into DB_BORROW{uid,bid} values(#{uid},#{bid})")
    int addBorrow(int uid,int bid);
}

