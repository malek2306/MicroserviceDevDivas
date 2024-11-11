package com.esprit.ms.msmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategorieRestAPI {

    @Autowired
    private CategorieService categorieService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        return new ResponseEntity<>(categorieService.addCategorie(categorie), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAll() {
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") int id,
                                                     @RequestBody Categorie categorie) {
        Categorie updatedCategorie = categorieService.updateCategorie(id, categorie);
        if (updatedCategorie != null) {
            return new ResponseEntity<>(updatedCategorie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Categorie not found
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCategorie(@PathVariable(value = "id") int id) {
        String response = categorieService.deleteCategorie(id);
        if (response.equals("Categorie supprimée")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Categorie not found
        }
    }
}
