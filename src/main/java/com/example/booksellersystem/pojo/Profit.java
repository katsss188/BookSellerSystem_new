package com.example.booksellersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class Profit {
    private String bid;
    private Integer profit;
    private Timestamp time;
    private Integer count;

}
