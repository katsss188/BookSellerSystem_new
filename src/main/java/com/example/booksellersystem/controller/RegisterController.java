package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterService registerService;
    @RequestMapping("/register")
    public Result register(@RequestBody Account account){
       if(registerService.register(account) == 1)
           return Result.success();
        return Result.error("该用户已经注册");
    }
}
