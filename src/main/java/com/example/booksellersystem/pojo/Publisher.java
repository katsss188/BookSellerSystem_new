package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
* 出版商 -- publisher
*- 编号(主键) -- id -- char(4) -- not null
*- 名称 -- name -- varchar(20)-- not null
*- 联系方式 -- contact -- varchar(20)-- not null
* */

@AllArgsConstructor
@Data
public class Publisher {
    private  String id;
    private  String name;
    private  String contact;
}
