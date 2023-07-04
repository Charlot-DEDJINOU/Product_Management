package com.charlot.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charlot.api.model.Produit;
import com.charlot.api.service.ProduitService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {

	
	private final ProduitService produitService ;

	@PostMapping("/create")
	public Produit create(@RequestBody Produit produit) {
		return produitService.create(produit);
	}

	@GetMapping("/list")
	public List<Produit> list() {
		return produitService.list();
	}

	@GetMapping("/read/{id}")
	public Produit read(@PathVariable Long id) {
		return produitService.read(id);
	}

	@PutMapping("/update/{id}")
	public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
		return produitService.update(id, produit);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		return produitService.delete(id);
	}

}
