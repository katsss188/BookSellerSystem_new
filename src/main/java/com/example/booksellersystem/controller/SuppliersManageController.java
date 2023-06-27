package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.pojo.Suppliers;
import com.example.booksellersystem.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager/suppliers")
public class SuppliersManageController {

    @Autowired
    private SuppliersService suppliersService;

    @RequestMapping("/add")
    public Result SuppliersAdd(@RequestBody Suppliers add_Suppliers){
        String mes;
        if(suppliersService.SuppliersAdd(add_Suppliers)==1){
            mes = "add success!";
        }
        else{
            mes = "name has survived,add failed!";
        }
        return new Result(suppliersService.SuppliersAdd(add_Suppliers),mes,null);
    }

    @RequestMapping("/search")
    public Result SuppliersSearch(@RequestBody Map<String,Object> param){
        Integer page = (Integer) param.get("page");
        Integer size = (Integer) param.get("size");
        return Result.success(suppliersService.SuppliersSearch(page,size));
    }

    @RequestMapping("/change")
    public Result SuppliersChange(@RequestBody Suppliers supplier){
        suppliersService.SuppliersChange(supplier);
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result SuppliersDelete(@RequestBody List<String> ID){
        suppliersService.SuppliersDelete(ID);
        return Result.success();
    }

    @RequestMapping("/count")
    public Result SuppliersCount(){
        return Result.success(suppliersService.SuppliersCount());
    }
}
