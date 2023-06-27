package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

//相比于Book，这个才是主用的
@Data
@AllArgsConstructor
public class Book_2{
        private String id;
        private String name ;
        private String author ;
        private Integer inventory ;//- 库存数量 --
        private String  attribute ;//- 属性（科幻、悬疑等）--
        private String  type;//- 类型（小说、文学等）--
        private String  ISBN ;//- 书号 --
        private Integer price;
        private String pid;//出版
        private String sid ;//供货
        private String image;
        private String pname;
        private String sname;

       // private Integer hot;
}

