package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.mapper.SalesDataMapper;

import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.pojo.Profit;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.service.SalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
public class SaveDataServiceA implements SalesDataService {
    @Autowired
    private SalesDataMapper salesDataMapper;

    @Override
    public List<Structure2> SalesDataSearchBook() {
        List<Structure2> SaleData = new ArrayList<>();
        List<String> bids = salesDataMapper.searchBidByInb();//用户表

        for (String i : bids) {
            Structure2 MyData = new Structure2();
            MyData.bid = i;
            if(salesDataMapper.isInPurchase(i) != 0)
                for (Profit j : salesDataMapper.searchBookSaleData(i)) {
                    MyData.profit += j.getProfit();
                    MyData.price += j.getCount();
                    if (MyData.profit<0){
                        MyData.profit = 0;
                    }
                }
            SaleData.add(MyData);
        }
        return SaleData;
    }
   @Override
   public List<Structure2> SalesDataSearchOneBook(String BookName) {

       List<Structure2> SalesData = new ArrayList<>();
       for (String j:salesDataMapper.searchBookName(BookName)) {
           Structure2 MyData = new Structure2();
           int cost = salesDataMapper.getPriceA(j);
           for (Purchase i : salesDataMapper.searchBookSaleDataA(j)) {
               MyData.price += i.getPrice() * i.getCount();
               System.out.println(i.getCount());
               MyData.profit += (i.getPrice() - cost) * i.getCount();
               MyData.bid = i.getBid();
           }
           SalesData.add(MyData);
       }
       return SalesData;
   }
    @Override
    public List<Structure3> SalesDataSearchDate() {
        List<Structure3> SaleData = new ArrayList<>();
        List<Timestamp> books = salesDataMapper.searchDate();
        List<Integer> mons = new ArrayList<>();

        for (Timestamp i : books) {
            Structure3 MyData = new Structure3();

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(i.getTime());
            MyData.month = calendar.get(Calendar.MONTH) + 1;
            if (mons.size()==12){
                break;
            }
            if (mons.contains(MyData.month)){
                continue;
            }
            mons.add(MyData.month);
            MyData.year = calendar.get(Calendar.YEAR);
            int cost = salesDataMapper.getPriceD(i).get(0);
            for (Purchase j : salesDataMapper.searchDateSales(MyData.year, MyData.month)) {
                MyData.price += j.getPrice() * j.getCount();
                MyData.profit += (j.getPrice() - cost) * j.getCount();
                if (MyData.profit<0){
                    MyData.profit = 0;
                }
            }
            SaleData.add(MyData);
        }
        return SaleData;
    }

    @Override
    public int CountSalesDataSearchDate() {

        return this.SalesDataSearchDate().size();
    }

    @Override
    public int CountSalesDataSearchBook() {

        return this.SalesDataSearchBook().size();
    }
}
