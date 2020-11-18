package com.example.ad8.db;

import org.litepal.crud.LitePalSupport;

import lombok.Data;

@Data
public class Ad8County extends LitePalSupport {
    private long id;
    private String countyName;
    private String countyCode;
    private long cityId;
    private long provinceId;
    private long weatherId;

}
