package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface SystemMapper {

    @Select("select * from suppliers " +
            "limit #{page}, #{size}")
    public List<Suppliers> renewSuppliers(int page,int size);

    @Select("select book.*,suppliers.name sname,publisher.name pname " +
            "from book,suppliers,publisher" +
            " where book.pid = publisher.id and book.sid = suppliers.id " +
            "limit #{page}, #{size}")
    public List<Book_2> renewBook(int page,int size);
    @Select("select * from publisher " +
            "limit #{page}, #{size}")
    public List<Publisher> renewPublishers(int page, int size);

    @Select("select * from purchase " +
            "limit #{page}, #{size}")
    public List<Purchase> renewPurchase(int page,int size);


    @Update("update book set hot = hot - 10 where hot > 10")
    public void flushHot();

    @Select("select book.*,suppliers.name sname,publisher.name pname " +
            "from book,suppliers,publisher" +
            " where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by hot desc " +
            "limit 0, 10")
    public List<Book_2> renewHottable();


    @Select("select  count(*) from book")
    public int numOfBook();
    @Select("select  count(*) from account where type = 1")
    public int numOfAccount();
    @Select("select  count(*) from inbound")
    public int numOfInbound();
    @Select("select  count(*) from publisher")
    public int numOfPublisher();
    @Select("select  count(*) from purchase")
    public int numOfPurchase();
    @Select("select  count(*) from suppliers")
    public int numOfSuppliers();









}
