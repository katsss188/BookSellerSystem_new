package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
*供应商 -- suppliers
 - 编号(主键) -- id -- char(4)-- not null
 - 名称 -- name -- varchar(20)-- not null
 - 地址 -- address --varchar(20)-- not null
 - 联系方式 -- contact -- varchar(20)-- not null
* */
@AllArgsConstructor
@Data
public class Suppliers {
    private String id;
    private String name;
    private String address;
    private String contact;
}
