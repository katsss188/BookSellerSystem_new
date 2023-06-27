package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PurchaseBooks {
    private String bid;//书号
    private Integer num;//买几本
    private Integer uid;
}
