package com.esprit.ms.msmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    public Dish addDish(Dish dish) {
        Optional<Categorie> categorieOpt = categorieRepository.findById(dish.getCategorie().getId());
        if (categorieOpt.isPresent()) {
            dish.setCategorie(categorieOpt.get()); // Lier le plat à la catégorie existante
            return dishRepository.save(dish);
        } else {
            throw new RuntimeException("Categorie non trouvée");
        }
    }

    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    public Dish updateDish(int id, Dish newDish) {
        Optional<Dish> existingDishOpt = dishRepository.findById(id);
        if (existingDishOpt.isPresent()) {
            Dish existingDish = existingDishOpt.get();
            existingDish.setNom(newDish.getNom());
            existingDish.setDescription(newDish.getDescription());
            existingDish.setPrix(newDish.getPrix());
            existingDish.setDisponibilite(newDish.isDisponibilite());

            // Si la catégorie est modifiée, vérifier son existence et l'assigner
            if (newDish.getCategorie() != null) {
                Optional<Categorie> categorieOpt = categorieRepository.findById(newDish.getCategorie().getId());
                categorieOpt.ifPresent(existingDish::setCategorie);
            }

            return dishRepository.save(existingDish);
        } else {
            return null; // Dish not found
        }
    }

    public String deleteDish(int id) {
        if (dishRepository.findById(id).isPresent()) {
            dishRepository.deleteById(id);
            return "Dish supprimé";
        } else {
            return "Dish non supprimé, non trouvé";
        }
    }
}
