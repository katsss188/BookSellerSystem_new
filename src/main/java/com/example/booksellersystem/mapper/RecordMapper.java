package com.example.booksellersystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface RecordMapper {

    @Insert("insert into record(contact, type,method, intime,classname) values(#{contact},#{type},#{method},#{intime},#{className})")
    public void insert(String contact, String type,String method, LocalDateTime intime,String className);
}
