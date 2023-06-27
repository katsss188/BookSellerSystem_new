package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.PurchaseBooks;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface LpurchaseMapper {
    @Data
    @AllArgsConstructor
    //必须能读进去。
    class Purchase_2{
        private Integer id;
        private String uid;
        private String bid;
        private  Integer price;
        private  Integer count;
        private Timestamp time;
        private String name;
        private String pname;

    }
    @Select("select purchase.*,book.name,publisher.name pname from purchase,book,publisher " +
            "where uid = #{contact} and book.id = purchase.bid and publisher.id = book.pid " +
            "limit #{page}, #{size}")
    public List<Purchase_2> getPurchase(String contact,int page,int size);

    @Select("select count(*) from purchase,book,publisher " +
            "where uid = #{contact} and book.id = purchase.bid and publisher.id = book.pid ")
    public Integer getPurchaseNum(String contact);

    @Insert("insert into purchase(uid,bid,count,price,time) values(#{uid},#{bid},#{num},(select book.price from book where #{bid} = book.id), now())")
    public void setPurchase(PurchaseBooks purchaseBooks);
}
