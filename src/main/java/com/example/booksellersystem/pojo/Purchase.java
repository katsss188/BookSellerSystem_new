package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;
/**
 * 购买记录 -- purchase
 * - 编号(主键,自增) -- id -- Integer
 * 	- 用户编号 -- uid -- varchar(20)---- not null
 * 	- 购买书籍编号 -- bid -- cahr(4)---- not null
 * 	- 购买单价 -- price -- Integer-- not null
 * 	- 购买数量 -- count -- Integer-- not null
 */
@AllArgsConstructor
@Data
public class Purchase {
    private Integer id;
    private String uid;
    private String bid;
    private  Integer price;
    private  Integer count;
    private Timestamp time;
}
