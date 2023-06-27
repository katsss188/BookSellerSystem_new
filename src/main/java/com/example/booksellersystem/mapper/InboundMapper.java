package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.pojo.Inbound;
import com.example.booksellersystem.pojo.Suppliers;
import com.example.booksellersystem.service.InboundService;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InboundMapper {

    @Select("select inbound.id,inbound.name,inbound.count,suppliers.name as sname,price,time ,bid " +
            "from inbound,suppliers" +
            " where suppliers.id = inbound.sid" +
            " limit #{page},#{size}")
    public List<InboundService.InboundA> search(int page, int size);

   /* @Select("select * from inbound,suppliers where id = #{BookID} AND suppliers.id = inbound.sid")
    public Inbound searchOne(String BookID);*/


    @Select("select * from book")
    public List<Book> surples();


    @Insert("insert into book (id,name,author,inventory,attribute,type,ISBN,price,pid,sid)" +
            "VALUES (#{id},#{name},#{author},#{inventory},#{attribute},#{type},#{ISBN},#{price},#{pid},#{sid})")
    public void addbook(Book newbook);
}

