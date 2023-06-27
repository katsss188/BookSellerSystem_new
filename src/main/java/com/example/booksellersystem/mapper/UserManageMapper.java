package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Suppliers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserManageMapper {

    @Delete("delete from account where contact = #{contact} AND type = 1")
    public void delete(String contact);

    @Select("select * from account where type = 1 " +
            " limit #{page},#{size}")
    public List<Account> search(int page,int size);

    @Select("select count(*) from account where type = 1")
    public int count();
}