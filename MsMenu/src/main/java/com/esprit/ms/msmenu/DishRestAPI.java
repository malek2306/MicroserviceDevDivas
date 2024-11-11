package com.esprit.ms.msmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Dishes")
public class DishRestAPI {
    @Autowired
    private DishService dishService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createDish(@RequestBody Dish dish) {
        try {
            Dish createdDish = dishService.addDish(dish);
            return new ResponseEntity<>(createdDish, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Log de l'exception pour comprendre l'erreur
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Dish>> getAll() {
        return new ResponseEntity<>(dishService.getAllDishes(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> updateDish(@PathVariable(value = "id") int id,
                                           @RequestBody Dish dish) {
        Dish updatedDish = dishService.updateDish(id, dish);
        if (updatedDish != null) {
            return new ResponseEntity<>(updatedDish, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); // Dish not found
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteDish(@PathVariable(value = "id") int id) {
        String response = dishService.deleteDish(id);
        if (response.equals("Dish supprimé")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // Dish not found
        }
    }
}
