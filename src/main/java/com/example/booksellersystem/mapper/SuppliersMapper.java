package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Suppliers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SuppliersMapper {

    @Select("select count(*) from suppliers where id = #{id}")
    public int count(Suppliers supplier);

    @Select("select count(*) from suppliers")
    public int countAll();

    @Select("select * from suppliers" +
            " limit #{page},#{size}")
    public List<Suppliers> search(int page,int size);

    @Insert("insert into suppliers " +
            "    values(#{id}, #{name},#{address },#{contact})")
    public void add(Suppliers supplier);


    @Update("update suppliers set name = #{name},address = #{address},contact = #{contact} where id = #{id}")
    public void update(Suppliers supplier);

    @Delete("delete from suppliers where id = #{id}")
    public void delete(String id);
}