package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

public interface SalesDataService {
    public List<Structure2> SalesDataSearchBook();

    public List<Structure2> SalesDataSearchOneBook(String BookName);

    public List<Structure3> SalesDataSearchDate();
    public int CountSalesDataSearchDate();
    public int CountSalesDataSearchBook();

    //书的销售记录
    public class Structure2{
        public String bid;
        public int price;
        public int profit;
        public int count;
    }
    //日期的销售记录
    public class Structure3{
        public int price;
        public int profit;
        public int year;
        public int month;
    }
}
