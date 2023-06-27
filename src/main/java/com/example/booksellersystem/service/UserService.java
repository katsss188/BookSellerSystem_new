package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.PurchaseBooks;

import java.util.List;

public interface UserService {
    public  int userChange(Account account);
    public List<?> getPurchase(String contact,int page,int size);
    public List<?> searchBook(String name,String author,String attribute,String type,String pname,String sname,int page,int size,String order);
    public Integer searchBookNum(String name,String author,String attribute,String type,String pname,String sname,int page,int size);
    public int purchaseBook(List<PurchaseBooks> list);
    public Integer getPurchaseNum(String contact);
    }
