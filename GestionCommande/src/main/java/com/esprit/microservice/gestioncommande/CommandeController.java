package com.esprit.microservice.gestioncommande;



import com.esprit.microservice.gestioncommande.Commande;
import com.esprit.microservice.gestioncommande.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Créer une nouvelle commande
    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        Commande createdCommande = commandeService.addCommande(commande);
        return new ResponseEntity<>(createdCommande, HttpStatus.CREATED);
    }

    // Récupérer toutes les commandes
    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        List<Commande> commandes = commandeService.getAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    // Récupérer une commande par ID
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable int id) {
        Commande commande = commandeService.getCommandeById(id);
        return commande != null ?
                new ResponseEntity<>(commande, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Mettre à jour une commande
    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(@PathVariable int id, @RequestBody Commande newCommande) {
        Commande updatedCommande = commandeService.updateCommande(id, newCommande);
        return updatedCommande != null ?
                new ResponseEntity<>(updatedCommande, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable int id) {
        String responseMessage = commandeService.deleteCommande(id);
        return responseMessage.equals("Commande supprimée") ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
