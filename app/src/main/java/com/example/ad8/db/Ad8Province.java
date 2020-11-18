package com.example.ad8.db;

import org.litepal.crud.LitePalSupport;

import lombok.Data;

@Data
public class Ad8Province extends LitePalSupport {

    private long id;
    private String provinceName;
    private String provinceCode;

}
