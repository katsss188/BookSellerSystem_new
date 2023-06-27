package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LaccountMapper {

    @Select("select * from account where contact = #{contact} and password = #{password}")
    public Account login(String contact,String password);

    @Select("select count(*) from account where contact = #{contact} ")
    public int SelectNum(Account account);

    @Insert("insert into account\n" +
            "    values(#{type},#{ name},#{sex },#{age},#{contact},#{ password})")
    public void register(Account account);

    @Update("update account set name = #{name}, sex = #{sex},age = #{age},password = #{password} where contact = #{contact}")
    public void update(Account account);
}
