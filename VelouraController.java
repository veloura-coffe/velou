package com.veloura.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VelouraController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "VELOURA | Premium Coffee Experience");
        return "index";
    }

    @PostMapping("/commander")
    public String traiterCommande(@RequestParam String nom, 
                                 @RequestParam String tel,
                                 @RequestParam String produit,
                                 @RequestParam int quantite,
                                 Model model) {
        
        // Simulation de calcul de prix total
        int prixUnitaire = Integer.parseInt(produit);
        int total = prixUnitaire * quantite;

        model.addAttribute("clientNom", nom);
        model.addAttribute("total", total);
        
        // Redirection vers une vue de succès
        return "success";
    }
}
