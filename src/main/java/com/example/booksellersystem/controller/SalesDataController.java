package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.SalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequestMapping("/manager/salesdata")
@RestController
public class SalesDataController {
    @Autowired
    private SalesDataService salesDataService;

    //返回销售记录
    @RequestMapping("/Book")
    public Result SalesDataSearchBook(){
        return Result.success(salesDataService.SalesDataSearchBook());
    }
    //返回销售记录总量
    @RequestMapping("/CBook")
    public Result CountSalesDataSearchBook(){
        return Result.success(salesDataService.CountSalesDataSearchBook());
    }
   @RequestMapping("/OneBook")
    public Result SalesDataSearchOneBook(@RequestBody HashMap<String,Object> param){
       String BookName = (String) param.get("BookName");
        return Result.success(salesDataService.SalesDataSearchOneBook(BookName));
    }


    //按照日期的销售记录
    @RequestMapping("/Date")
    public Result SalesDataSearchDate(){
        return Result.success(salesDataService.SalesDataSearchDate());
    }
    ////日期的销售记录总量
    @RequestMapping("/CDate")
    public Result CountSalesDataSearchDate(){
        return Result.success(salesDataService.CountSalesDataSearchDate());
    }
}
