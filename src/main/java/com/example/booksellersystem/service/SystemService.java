package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Book_2;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.pojo.Suppliers;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemService {


    public List<Suppliers> renewSuppliers(int page,int size);

    public List<Book_2> renewBook(int page,int size);

    public List<?> renewPublishers(int page,int size);


    public List<Purchase> renewPurchase(int page,int size);

    public List<Book_2> renewHottable();

    public int numOfbook();
    public int numOfinbound();
    public int numOfpublisher();
    public int numOfpurchase();
    public int numOfsuppliers();
    public int numOfaccount();
   // public int numOfbook();





}
