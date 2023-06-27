package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Result;

import java.util.List;

public interface UserManageService {
    public List<Account> MUserSearch(int page,int size);
    public int MUserDelete(List<String> contact);
    public int MUsercount();
}
