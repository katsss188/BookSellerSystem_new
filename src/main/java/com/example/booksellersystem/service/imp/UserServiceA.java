package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.mapper.LaccountMapper;
import com.example.booksellersystem.mapper.LbookMapper;
import com.example.booksellersystem.mapper.LpurchaseMapper;
import com.example.booksellersystem.pojo.Account;
import com.example.booksellersystem.pojo.Purchase;
import com.example.booksellersystem.pojo.PurchaseBooks;
import com.example.booksellersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceA implements UserService {
    @Autowired
    private LaccountMapper laccountMapper;
    @Autowired
    private LpurchaseMapper lpurchaseMapper;
    @Autowired
    private LbookMapper lbookMapper;

    @Override
    public int userChange(Account account) {
        laccountMapper.update(account);
        return 0;
    }
    @Override
    public List<?> getPurchase(String contact,int page ,int size){
       return lpurchaseMapper.getPurchase(contact, (page - 1) * size,size);
    }

    @Override
    public List<?> searchBook(String name,String author,String attribute,String type,String pname,String sname,int page ,int size,String order){
        if(order == "")
            return lbookMapper.searchBook( name, author, attribute, type, pname,sname,(page - 1) * size, size);
        else if(order.equals("priceA"))
            return lbookMapper.searchBookOfPA( name, author, attribute, type, pname,sname,(page - 1) * size, size);
        else if(order.equals("priceD"))
            return lbookMapper.searchBookOfPD( name, author, attribute, type, pname,sname,(page - 1) * size, size);
        else if(order.equals("inventoryA"))
            return lbookMapper.searchBookOfIA( name, author, attribute, type, pname,sname,(page - 1) * size, size);
        else if(order.equals("inventoryD"))
            return lbookMapper.searchBookOfID( name, author, attribute, type, pname,sname,(page - 1) * size, size);
        return null;
    }

    @Override
    public Integer searchBookNum(String name, String author, String attribute, String type, String pname, String sname, int page, int size) {
        return lbookMapper.searchBookNum(name, author, attribute, type, pname, sname);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int purchaseBook(List<PurchaseBooks> list) {


            list.stream().forEach(l->{
                lbookMapper.purchaseBook(l);
                lpurchaseMapper.setPurchase(l);
            });

        return 1;

    }

    @Override
    public Integer getPurchaseNum(String contact) {
        return lpurchaseMapper.getPurchaseNum(contact);
    }


}
