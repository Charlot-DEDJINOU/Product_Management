package com.charlot.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.charlot.api.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
