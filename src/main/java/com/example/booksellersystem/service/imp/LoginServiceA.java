package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.mapper.LaccountMapper;
import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceA implements LoginService {
    @Autowired
    private LaccountMapper laccountMapper;
    @Override
    public Account Login(String contact, String password) {

       //测试下全部异常处理， int a = 1 / 0;

        return laccountMapper.login( contact, password) ;
    }
}
