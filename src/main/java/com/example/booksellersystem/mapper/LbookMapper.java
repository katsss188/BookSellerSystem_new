package com.example.booksellersystem.mapper;

import com.example.booksellersystem.pojo.Book_2;
import com.example.booksellersystem.pojo.PurchaseBooks;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LbookMapper {
    //
    @Select("select * from book where id = #{id}")
    public List<String> getBookName(String id);

    //查找书表
    //不是我想写这么长，xml文件一直报错啊，NND
    //一个很拉的模糊匹配，不如我们就当它没有模糊匹配吧
    @Select("select * from book_2 as a" +
            " where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') " +
            "limit #{page}, #{size}")
    public List<Book_2> searchBook(String name, String author, String attribute, String type,
                                   String pname, String sname, int page,int size);

    @Select("select * from book_2 as a" +
            " where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') " +
            "order by price asc " +
            "limit #{page}, #{size}")
    public List<Book_2> searchBookOfPA(String name, String author, String attribute, String type,
                                   String pname, String sname, int page,int size);

    @Select("select * from book_2 as a" +
            " where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') " +
            " order by price desc " +
            "limit #{page}, #{size}")
    public List<Book_2> searchBookOfPD(String name, String author, String attribute, String type,
                                   String pname, String sname, int page,int size);

    @Select("select * from book_2 as a" +
            " where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') " +
            " order by inventory asc  "  +
            "limit #{page}, #{size}")
    public List<Book_2> searchBookOfIA(String name, String author, String attribute, String type,
                                   String pname, String sname, int page,int size);

    @Select("select * from book_2 as a" +
            " where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') " +
            " order by inventory desc " +
            "limit #{page}, #{size}")
    public List<Book_2> searchBookOfID(String name, String author, String attribute, String type,
                                   String pname, String sname, int page,int size);


    //查找书表
    //不是我想写这么长，xml文件一直报错啊，NND
    //一个很拉的模糊匹配，不如我们就当它没有模糊匹配吧

    @Select(" select count(*) from book_2 where( name like concat('%', #{name} ,'%') or #{name} = '' ) and (author like concat('%',#{author},'%')  or #{author} = '') and " +
            "(attribute = #{attribute} or  #{attribute} = '') and " +
            "(type = #{type} or  #{type} = '') and (pname like concat('%',#{pname} ,'%') or  #{pname} = '') ")
    public Integer searchBookNum(String name, String author, String attribute, String type,
                                   String pname, String sname);

    //买书
    @Update("update  book set inventory = inventory - #{num} ,hot = hot + #{num}  where id = #{bid}")
    public void purchaseBook(PurchaseBooks purchaseBooks);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(book.name USING gbk) asc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortNameA(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(book.name USING gbk) desc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortNameD(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(author USING gbk) asc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortAuthorA(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(author USING gbk) desc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortAuthorD(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(pname USING gbk) desc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortPnameD(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(pname USING gbk) asc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortPnameA(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(sname USING gbk) asc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortSnameA(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  CONVERT(sname USING gbk) desc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortSnameD(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  price desc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortPriceD(int page,int size);

    @Select("select publisher.name pname,suppliers.name sname,book.* from book,publisher,suppliers " +
            "where book.pid = publisher.id and book.sid = suppliers.id " +
            "order by  price asc " +
            "limit #{page}, #{size}")
    public List<Book_2> sortPriceA(int page,int size);
}
