package ms.produitp.RestControllers;


import lombok.RequiredArgsConstructor;
import ms.produitp.Entities.ProduitPrimaire;
import ms.produitp.Services.IProduitPrimaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produitsPrimaires")
public class ProduitPrimaireController {

    private final IProduitPrimaireService produitsPrimairesService;

    private String hello="Hello, i'm the Job MS";

    @RequestMapping("/helloJ")
    public String sayHello(){
        return hello;
    }
    @PostMapping("/addProduitPrimaire")
    public ProduitPrimaire addProduitPrimaire(@RequestBody ProduitPrimaire produitPrimaire) {

        return produitsPrimairesService.addProduitPrimaire(produitPrimaire);
    }

    @PutMapping("/updateProduitPrimaire")
    public ProduitPrimaire updateProduitPrimaire(@RequestBody ProduitPrimaire produitPrimaire) {
        return produitsPrimairesService.updateProduitPrimaire(produitPrimaire);
    }

    @DeleteMapping("/deleteProduitPrimaire/{id}")
    public void deleteProduitPrimaire(@PathVariable Long id) {
        produitsPrimairesService.deleteProduitPrimaire(id);
    }

    @GetMapping("/getProduitPrimaire/{id}")
    public ProduitPrimaire getProduitPrimaire(@PathVariable Long id) {
        return produitsPrimairesService.getProduitPrimaire(id);
    }

    @GetMapping("/getProduitPrimaireByNom/{nom}")
    public ProduitPrimaire getProduitPrimaireByNom(@PathVariable String nom) {
        return produitsPrimairesService.getProduitPrimaireByNom(nom);
    }

    @GetMapping("/getAllProduitsPrimaires")
    public List<ProduitPrimaire> getAllProduitsPrimaires() {
        return produitsPrimairesService.getAllProduitsPrimaires();
    }
}

