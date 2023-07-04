package com.charlot.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.charlot.frontend.model.Produit;
import com.charlot.frontend.service.ProduitService;

@Controller
public class ProduitController {

    @Autowired
    public ProduitService service;

    @GetMapping("/")
    public String home(Model model) {
        List<Produit> listproduit = service.getProduits();
        model.addAttribute("produits", listproduit);

        return "home";
    }

    @GetMapping("/updateProduit/{id}")
    public String updateProduit(@PathVariable("id") final int id, Model model) {
        Produit e = service.getProduit(id);
        model.addAttribute("produit", e);

        return "formUpdateProduit";
    }

    @GetMapping("/createProduit")
    public String createProduit(Model model) {
        model.addAttribute("produit", new Produit());
        return "formNewProduit";
    }

    @PostMapping("/saveProduit")
    public String save(@ModelAttribute("produit") Produit produit) {
        service.saveProduit(produit);
        return "redirect:/";
    }

    @GetMapping("/deleteProduit/{id}")
    public ModelAndView deleteProduit(@PathVariable("id") final int id) {
        service.deleteProduit(id);
        return new ModelAndView("redirect:/");
    }

}