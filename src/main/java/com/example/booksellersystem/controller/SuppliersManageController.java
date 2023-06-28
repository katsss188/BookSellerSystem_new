package com.example.booksellersystem.controller;

import com.example.booksellersystem.pojo.Result;
import com.example.booksellersystem.pojo.Suppliers;
import com.example.booksellersystem.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
        int jud = suppliersService.SuppliersAdd(add_Suppliers);
        if(jud == 1){
            mes = "add success!";
        }
        else{
            mes = "name has survived,add failed!";
        }
        return new Result(jud,mes,null);
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
    public Result SuppliersDelete(@RequestBody HashMap<String,Object> param){
        List<String> suppliers = (List<String>) param.get("suppliers");
        suppliersService.SuppliersDelete(suppliers);
        return Result.success();
    }

    @RequestMapping("/count")
    public Result SuppliersCount(){
        return Result.success(suppliersService.SuppliersCount());
    }
}
