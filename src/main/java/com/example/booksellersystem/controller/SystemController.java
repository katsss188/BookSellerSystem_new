package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.SystemService;
import com.example.booksellersystem.util.MyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//一些系统功能部分
@RestController
@RequestMapping({"/user", "/manager"})
public class SystemController {

    @Autowired
    private SystemService systemService;

    @MyLog
    @RequestMapping("/suppliers")
    public Result renewSuppliers(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        List<?> list = systemService.renewSuppliers( page, size);
        Map<String,Object> map = new HashMap<>();
        map.put("suppliersNum",list.size());
        map.put("suppliers",list);
        return Result.success(map);
    }
    @MyLog
    @RequestMapping("/book")
   public Result renewBook(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        List<?> list = systemService.renewBook( page,size);
        Map<String,Object> map = new HashMap<>();
        map.put("bookNum",list.size());
        map.put("book",list);
        return Result.success(map);
    }


    @MyLog
    @RequestMapping("/publisher")
    public Result renewPublishers(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");

        List<?> list = systemService.renewPublishers(page,size);
        Map<String,Object> map = new HashMap<>();
        map.put("publisherNum",list.size());
        map.put("publisher",list);

        return Result.success(map);
    }
    @MyLog
    @RequestMapping("/purchase")
    public Result renewPurchase(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");

        List<?> list = systemService.renewPurchase(page,size);
        Map<String,Object> map = new HashMap<>();
        map.put("purchaseNum",list.size());
        map.put("purchase",list);

        return Result.success(map);
    }
    @MyLog
    @RequestMapping("/hottable")
    public Result renewHottable(){
        return Result.success(systemService.renewHottable());
    }

    @MyLog
    @RequestMapping("/booknum")
    public Result numOfbook(){
        return Result.success(systemService.numOfbook());
    }
    @MyLog
    @RequestMapping("/accountnum")
    public Result numOfaccount(){
        return Result.success(systemService.numOfaccount());
    }

    @MyLog
    @RequestMapping("/inboundnum")
    public Result numOfinbound(){
        return Result.success(systemService.numOfinbound());
    }

    @MyLog
    @RequestMapping("/publishernum")
    public Result numOfpublisher(){
        return Result.success(systemService.numOfpublisher());
    }
    @MyLog
    @RequestMapping("/purchasenum")
    public Result numOfpurchase(){
        return Result.success(systemService.numOfpurchase());
    }
    @MyLog
    @RequestMapping("/suppliersnum")
    public Result numOfsuppliers(){
        return Result.success(systemService.numOfsuppliers());
    }

}
