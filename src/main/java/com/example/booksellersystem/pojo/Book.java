package com.example.booksellersystem.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
/*
 book
	- 书籍编号(主键) -- id -- char(4) -- not null
	- 名称 -- name -- varchar(20)-- not null
	- 作者 -- author -- varchar(20)
	- 出版商编号 -- pid(or p_id) -- char(4) -- not null
	- 供应商编号 -- sid -- char(4) -- not null
	- 库存数量 -- inventory -- int -- not null
	- 属性（科幻、悬疑等）-- attribute -- varchar(20)
	- 类型（小说、文学等）-- type -- varchar(20)
	- 书号 -- ISBN -- varchar(20) -- not null
	- 价格信息 -- price -- int -- not null
 */
//印象里好像没用过
@AllArgsConstructor
@Data
public class Book {
    private String id;
    private String name ;
    private String author ;
    private Integer   inventory ;//- 库存数量 --
    private String  attribute ;//- 属性（科幻、悬疑等）--
    private String  type;//- 类型（小说、文学等）--
    private String   ISBN ;//- 书号 --
    private Integer    price;
    private String pid;//出版
    private String sid ;//供货
    private  String image;
    private Integer hot;
}
