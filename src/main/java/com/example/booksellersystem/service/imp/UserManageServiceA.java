package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.service.UserManageService;
import com.example.booksellersystem.mapper.UserManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageServiceA implements UserManageService {

    @Autowired
    private UserManageMapper userManageMapper;

    @Override
    public int MUserDelete(List<String> contact) {
        for (String i : contact) {
            userManageMapper.delete(i);
        }
        return 1;
    }

    @Override
    public int MUsercount() {
        return userManageMapper.count();
    }

    @Override
    public List<Account> MUserSearch(int page,int size) {
        List<Account> temp = userManageMapper.search((page - 1) * size, size);
        for (Account i:temp){
            i.setPassword("");
        }
        return temp;
    }

}
