package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager/user")
public class UserManageController {
    @Autowired
    private UserManageService userManageService;

    @RequestMapping("/search")
    public Result MUserSearch(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        return Result.success(userManageService.MUserSearch(page,size));
    }

    @RequestMapping("/delete")
    public Result UserDelete(@RequestBody HashMap<String,Object> map){
        List<String> account = (List<String>) map.get("user");
        userManageService.MUserDelete(account);
        return Result.success();
    }

    @RequestMapping("/count")
    public Result MUsercount(){
        return Result.success(userManageService.MUsercount());
    }
}
