package com.esprit.ms.msmenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    public Categorie updateCategorie(int id, Categorie newCategorie) {
        if (categorieRepository.findById(id).isPresent()) {
            Categorie existingCategorie = categorieRepository.findById(id).get();
            existingCategorie.setType(newCategorie.getType()); // Mise à jour du type
            return categorieRepository.save(existingCategorie);
        } else {
            return null; // Si la catégorie n'existe pas
        }
    }

    public String deleteCategorie(int id) {
        if (categorieRepository.findById(id).isPresent()) {
            categorieRepository.deleteById(id);
            return "Categorie supprimée";
        } else {
            return "Categorie non trouvée";
        }
    }
}
