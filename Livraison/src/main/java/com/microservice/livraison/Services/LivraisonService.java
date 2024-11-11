package com.microservice.livraison.Services;

import com.microservice.livraison.Entities.Livraison;
import com.microservice.livraison.Repositories.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {
    @Autowired
    private LivraisonRepository livraisonRepository;

    // Add a new Livraison
    public Livraison addLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    // Update an existing Livraison
    public Livraison updateLivraison(int id, Livraison newLivraison) {
        Optional<Livraison> livraisonOptional = livraisonRepository.findById(id);
        if (livraisonOptional.isPresent()) {
            Livraison existingLivraison = livraisonOptional.get();
            existingLivraison.setDateLivraison(newLivraison.getDateLivraison());
            existingLivraison.setStatusLivraison(newLivraison.getStatusLivraison());
            return livraisonRepository.save(existingLivraison);
        } else {
            return null;
        }
    }

    // Delete a Livraison by ID
    public String deleteLivraison(int id) {
        if (livraisonRepository.findById(id).isPresent()) {
            livraisonRepository.deleteById(id);
            return "Livraison supprimée";
        } else {
            return "Livraison non trouvée";
        }
    }

    // Find a Livraison by ID
    public Livraison findLivraisonById(int id) {
        return livraisonRepository.findById(id).orElse(null);
    }

    // Get all Livraisons
    public List<Livraison> findAllLivraisons() {
        return livraisonRepository.findAll();
    }
}
