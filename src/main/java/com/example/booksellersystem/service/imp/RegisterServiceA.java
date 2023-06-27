package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.mapper.LaccountMapper;
import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceA implements RegisterService {
    @Autowired
    private LaccountMapper laccountMapper;
    @Override
    public int register(Account account) {

        if(laccountMapper.SelectNum(account) != 0){
            return 0;
        }
        laccountMapper.register(account);

        return 1;
    }
}
