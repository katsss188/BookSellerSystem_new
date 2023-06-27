package com.example.booksellersystem.service.imp;


import com.example.booksellersystem.mapper.SystemMapper;
import com.example.booksellersystem.pojo.Book_2;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.pojo.Suppliers;
import com.example.booksellersystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceA implements SystemService {
    @Autowired
    private SystemMapper systemMapper;
    @Override
    public List<Suppliers> renewSuppliers(int page,int size) {

        return systemMapper.renewSuppliers( (page - 1) * size,size);
    }

    @Override
    public List<Book_2> renewBook(int page,int size) {
        return systemMapper.renewBook((page - 1) * size,size);
    }

    @Override
    public List<?> renewPublishers(int page,int size) {
        return systemMapper.renewPublishers((page - 1) * size,size);
    }

    @Override
    public List<Purchase> renewPurchase(int page,int size) {
        return systemMapper.renewPurchase((page - 1) * size,size);
    }

    @Override
    public List<Book_2> renewHottable() {
        return systemMapper.renewHottable();
    }

    @Override
    public int numOfbook() {
        return systemMapper.numOfBook();
    }

    @Override
    public int numOfinbound() {
        return systemMapper.numOfInbound();
    }

    @Override
    public int numOfpublisher() {
        return systemMapper.numOfPublisher();
    }

    @Override
    public int numOfpurchase() {
        return systemMapper.numOfPurchase();
    }

    @Override
    public int numOfsuppliers() {
        return systemMapper.numOfSuppliers();
    }

    @Override
    public int numOfaccount() {
        return systemMapper.numOfAccount();
    }

}
