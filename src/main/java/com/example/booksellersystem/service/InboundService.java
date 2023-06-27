package com.example.booksellersystem.service;

import com.example.booksellersystem.pojo.Book;
import com.example.booksellersystem.pojo.Inbound;
import com.example.booksellersystem.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

public interface InboundService {
    public List<InboundA> InboundRecord(int page,int size);

   // public Object SRecordOne(String BookID);

    public List<Structure1> SurplesRepertory();
    public int AddBook(Book newbook);


    public class Structure1{
        public String name;
        public int inventory;
       // public int hot;
    }
    public class InboundA{
        public String id;
        public String name;
        public int count;
        public String sname;
        public int price;
        public Timestamp time;
        public String bid;
    }

}