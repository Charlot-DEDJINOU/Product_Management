package com.charlot.api.service;

import java.util.List;

import com.charlot.api.model.Produit;

public interface ProduitService {

    Produit create(Produit produit);

    List<Produit> list();

    Produit update(Long id, Produit produit);

    Produit read(Long id);

    String delete(Long id);
    
}
