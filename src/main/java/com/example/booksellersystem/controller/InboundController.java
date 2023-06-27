package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.InboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/manager/inbound")
public class InboundController {
    @Autowired
    private InboundService inboundService;

    @RequestMapping("/record")
    public Result SInboundRecord(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        return Result.success(inboundService.InboundRecord(page, size));
    }

    /*@RequestMapping("/recordone")
    public Result SRecordOne(String BookID){


        return Result.success(inboundService.SRecordOne(BookID));
    }*/

    @RequestMapping("/surples")
    public Result SurplesRepertory(){
        return Result.success(inboundService.SurplesRepertory());
    }
    @RequestMapping("/addBook")
    public Result AddBook(@RequestBody Book newbook){
        return Result.success(inboundService.AddBook(newbook));
    }
}
