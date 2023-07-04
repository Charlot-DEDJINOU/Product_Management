package com.charlot.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.charlot.api.model.Produit;
import com.charlot.api.repository.ProduitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
	
	private final ProduitRepository produitRepository ;

	@Override
	public Produit create(Produit produit) {
		return produitRepository.save(produit);
	}

	@Override
	public Produit read(Long id) {
		Produit produitInstance = produitRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produit id " + id + " not found !!!"));

		return produitInstance ;
	}

	@Override
	public String delete(Long id) {
		produitRepository.deleteById(id);
		return "Resource deleted!";
	}

	@Override
	public List<Produit> list() {
		return produitRepository.findAll();
	}

	@Override
	public Produit update(Long id, Produit produit) {
		Produit produitInstance = produitRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produit id " + id + " not found !!!"));

		produitInstance.setName(produit.getName());
		produitInstance.setPrice(produit.getPrice());
		produitInstance.setCurrency(produit.getCurrency());
		produitInstance.setTaxe(produit.getTaxe());
		produitInstance.setExpired_at(produit.getExpired_at());
		produitInstance.setProduced_by(produit.getProduced_by());

		return produitRepository.save(produitInstance);
	}

}
