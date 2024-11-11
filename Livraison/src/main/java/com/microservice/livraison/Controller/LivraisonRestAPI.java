package com.microservice.livraison.Controller;

import com.microservice.livraison.Entities.Livraison;
import com.microservice.livraison.Services.LivraisonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraison")
public class LivraisonRestAPI {

    @Autowired
    private LivraisonService livraisonService;
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Livraison> createLivraison(@RequestBody Livraison livraison) {
        // Directly call the service to add the Livraison
        return new ResponseEntity<>(livraisonService.addLivraison(livraison), HttpStatus.CREATED);
    }


    // Update an existing Livraison
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livraison> updateLivraison(@PathVariable(value = "id") int id,
                                                     @RequestBody Livraison livraison){
        return new ResponseEntity<>(livraisonService.updateLivraison(id, livraison), HttpStatus.OK);
    }

    // Delete a Livraison by ID
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteLivraison(@PathVariable(value = "id") int id) {
        // Directly call the service to delete the Livraison
        return new ResponseEntity<>(livraisonService.deleteLivraison(id), HttpStatus.OK);
    }


    // Find a Livraison by ID
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livraison> getLivraisonById(@PathVariable(value = "id") int id) {
        Livraison livraison = livraisonService.findLivraisonById(id);
        return livraison != null ? new ResponseEntity<>(livraison, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all Livraisons
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Livraison>> getAllLivraisons() {
        List<Livraison> livraisons = livraisonService.findAllLivraisons();
        return new ResponseEntity<>(livraisons, HttpStatus.OK);
    }
}
