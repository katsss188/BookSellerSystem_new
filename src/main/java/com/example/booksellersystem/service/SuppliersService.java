package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.pojo.Suppliers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SuppliersService {
    public int SuppliersAdd(Suppliers add_Suppliers);

    public List<Suppliers> SuppliersSearch(int page,int size);

    public int SuppliersChange(Suppliers supplier);

    public int SuppliersDelete(List<String> ID);
    public int SuppliersCount();
}
