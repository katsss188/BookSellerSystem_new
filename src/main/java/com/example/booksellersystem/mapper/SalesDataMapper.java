package com.example.booksellersystem.mapper;


import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.pojo.Profit;
import com.example.booksellersystem.pojo.Purchase;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SalesDataMapper {

    @Select("select bid from inbound")
    public List<String> searchBidByInb();

    @Select("select id from book where name = #{name} order by book.hot")
    public List<String> searchBookName(String name);
    @Select("select  purchase.* from purchase where purchase.bid = #{bid}")
    public List<Purchase> searchBookSaleDataA(String bid);
    @Select("select price from inbound where bid = #{bid}")
    public Integer getPriceA(String bid);

    @Select("select count(*) from book,purchase where book.id = purchase.bid")
    public int isInPurchase(String id);

    @Select("select inbound.price from inbound,purchase,book where purchase.time = #{date} AND purchase.bid = book.id " +
            "and book.id = inbound.bid")
    public List<Integer> getPriceD(Timestamp date);

    @Select("select time from purchase")
    public List<Timestamp> searchDate();

    @Select("select  * from newprofit where bid = #{id} ")
    public List<Profit> searchBookSaleData(String id);

   @Select("select * from purchase where YEAR(time) = #{year} " +
            "AND MONTH(time) = #{month}")
    public List<Purchase> searchDateSales(int year,int month);

}
