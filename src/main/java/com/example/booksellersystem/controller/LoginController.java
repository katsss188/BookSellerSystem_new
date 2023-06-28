package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.service.LoginService;
import com.example.booksellersystem.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//如名，登陆部分
@RestController
public class LoginController {

    @Autowired
    private  LoginService loginService;


    @RequestMapping("/login")
    public Result login(@RequestBody Map<String,Object> param) throws Exception{
        String contact = (String)param.get("contact");
        String password = (String)param.get("password");
        Account infor = loginService.Login(contact,password);
        if(infor != null){
            Map<String, Object> claims = new HashMap<>();
            Map<String,Object> ret = new HashMap<>();
            ret.put("account",infor);
            if(infor.getType() == 1){

                claims.put("account",contact);
                claims.put("type","user");
                String jwt = JwtUtils.generateJwt(claims,1);
                ret.put("jwt",jwt);
                return new Result(1,"user",ret);
            }else
            {
                claims.put("account",contact);
                claims.put("type","manager");
                String jwt = JwtUtils.generateJwt(claims,2);
                ret.put("jwt",jwt);
                return new Result(1,"manager",ret);
            }

        }
        return Result.error("用户名或密码错误");
    }

}
