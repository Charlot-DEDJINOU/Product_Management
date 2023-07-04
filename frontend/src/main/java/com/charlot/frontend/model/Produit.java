package com.charlot.frontend.model;

import lombok.Data;

@Data
public class Produit {
    
    private Integer id;
    private String name;
    private Integer price;
    private String currency;
    private Integer taxe;
    private String expired_at;
    private String produced_by;
}
