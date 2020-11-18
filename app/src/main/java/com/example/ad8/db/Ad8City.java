package com.example.ad8.db;

import org.litepal.crud.LitePalSupport;

import lombok.Data;

@Data
public class Ad8City extends LitePalSupport {

    private long id;
    private String cityName;
    private String cityCode;
    private long provinceId;

}
