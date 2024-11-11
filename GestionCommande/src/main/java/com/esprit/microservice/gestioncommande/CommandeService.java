package com.esprit.microservice.gestioncommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(int id, Commande newCommande) {
        if (commandeRepository.findById(id).isPresent()) {
            Commande existingCommande = commandeRepository.findById(id).get();
            existingCommande.setProduit(newCommande.getProduit());
            existingCommande.setQuantite(newCommande.getQuantite());
            existingCommande.setEstLivree(newCommande.isEstLivree());
            return commandeRepository.save(existingCommande);
        } else {
            return null;
        }
    }
    public Commande getCommandeById(int id) {
        return commandeRepository.findById(id).orElse(null); // Renvoie null si la commande n'existe pas
    }


    public String deleteCommande(int id) {
        if (commandeRepository.findById(id).isPresent()) {
            commandeRepository.deleteById(id);
            return "Commande supprimée";
        } else {
            return "Commande non trouvée";
        }
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}

