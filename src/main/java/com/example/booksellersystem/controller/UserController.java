package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.PurchaseBooks;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.UserService;
import com.example.booksellersystem.util.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用户部分的功能都在这了
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 用户信息修改
    * */
    @MyLog
    @RequestMapping("/userChange")
    public Result userChange(@RequestBody Account account){
            userService.userChange(account);
            return Result.success();
    }
    /*
    * 使用历史查询
    * */
    @MyLog
    @RequestMapping(value = "/userHistory",method = RequestMethod.POST)
    public Result userHistory(@RequestBody Map<String,Object> param){
        String contact = (String)param.get("contact");
        Integer page = (Integer)param.get("page");
        Integer size = (Integer)param.get("size");
        Map<String,Object> map = new HashMap<>();
        List<?> list = userService.getPurchase(contact,page,size);
        map.put("historynum",userService.getPurchaseNum(contact));
        map.put("purchase",list);
       if(list.size() != 0){
           return Result.success(map);
       }
        return Result.error("购买记录为空");
    }
    //图书搜索功能
    @MyLog
    @RequestMapping(value = "/searchBook",method = RequestMethod.POST)
    public Result searchBook(@RequestBody Map<String,Object> param){
        String name = (String)param.get("name");
        String author= (String)param.get("author");
        String attribute= (String)param.get("attribute");
        String type  = (String)param.get("type");
        String pname = (String)param.get("pname");
        String sname= (String)param.get("sname");
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        String order = (String) param.get("order");
        HashMap<String,Object> map = new HashMap<>();
        map.put("books",userService.searchBook( name, author, attribute, type, pname,sname,page,size,order));
        map.put("num",userService.searchBookNum( name, author, attribute, type, pname,sname,page,size));
        return Result.success( map);
        //return Result.error("null");
    }


    //见鬼，注意传参问题，比写还麻烦
    @MyLog
    @RequestMapping(value = "/purchase",method = RequestMethod.POST)
    public Result purchaseBook(@RequestBody List<PurchaseBooks> list){
        if(userService.purchaseBook(list) == 1)
            return Result.success();
        return Result.error("error");
    }

}
