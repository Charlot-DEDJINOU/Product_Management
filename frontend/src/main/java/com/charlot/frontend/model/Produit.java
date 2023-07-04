package com.charlot.frontend.model;

import java.util.Date;

import lombok.Data;

@Data
public class Produit {
    
    private Integer id;
    private String name;
    private Integer price;
    private String currency;
    private Integer taxe;
    private Date expired_at;
    private String produced_by;
}
