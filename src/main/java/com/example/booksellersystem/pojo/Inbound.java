package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
/**
 *  入库记录 -- inbound
 * 	- 编号(主键,自增) -- id -- int
 * 	- 书名 -- name -- varchar(20)
 * 	- 数量 -- count -- int
 * 	- 来自供应商的编号 -- sid -- char(4)
 * 	- 采购价格 -- price -- int
 */
public class Inbound {
    private Integer id;
    private String name;
    private Integer count;
    private String sid;
    private  Integer price;
    private Timestamp time;
    private String bid;
}
