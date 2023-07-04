package com.charlot.frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charlot.frontend.model.Produit;
import com.charlot.frontend.repository.ProduitProxy;

import lombok.Data;

@Data
@Service
public class ProduitService {

    @Autowired
    private ProduitProxy produitProxy;

    public Produit getProduit(final int id) {
        return produitProxy.getProduit(id);
    }

    public List<Produit> getProduits() {
        return produitProxy.getProduits();
    }

    public void deleteProduit(final int id) {
        produitProxy.deleteProduit(id);;
    }

     public Produit saveProduit(Produit produit) {

        Produit savedProduit;

        if(produit.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel produit.
            savedProduit = produitProxy.createProduit(produit);
        } else {
            savedProduit = produitProxy.updateProduit(produit);
        }
    
        return savedProduit;
    }

}