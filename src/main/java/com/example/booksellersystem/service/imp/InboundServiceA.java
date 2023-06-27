package com.example.booksellersystem.service.imp;

import com.example.booksellersystem.pojo.Inbound;
import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.service.InboundService;
import com.example.booksellersystem.mapper.InboundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InboundServiceA implements InboundService{
    @Autowired
    private InboundMapper inboundMapper;

    @Override
    public List<InboundA> InboundRecord(int page,int size) {

        return inboundMapper.search((page - 1) * size,size);
    }

   /* @Override
    public Inbound SRecordOne(String BookID) {
        return inboundMapper.searchOne(BookID);
    }*/

    @Override
    public List<Structure1> SurplesRepertory() {
        List<Structure1> SurplesData = new ArrayList<>();
        for(Book i:inboundMapper.surples()){
            Structure1 data = new Structure1();
            data.name = i.getName();
            data.inventory = i.getInventory();
            SurplesData.add(data);
        }
        return SurplesData;
    }

    @Override
    public int AddBook(Book newbook) {
        newbook.setPrice((int)Math.round(newbook.getPrice() * 1.1));
        inboundMapper.addbook(newbook);
        return 1;
    }


}
