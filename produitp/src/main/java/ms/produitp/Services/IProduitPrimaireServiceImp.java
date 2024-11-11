package ms.produitp.Services;


import lombok.RequiredArgsConstructor;
import ms.produitp.Entities.ProduitPrimaire;
import ms.produitp.Repositories.ProduitPrimaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IProduitPrimaireServiceImp implements IProduitPrimaireService{

    private final ProduitPrimaireRepository produitPrimaireRepository;
    @Override
    public ProduitPrimaire addProduitPrimaire(ProduitPrimaire produitPrimaire) {
        return produitPrimaireRepository.save(produitPrimaire);
    }

    @Override
    public ProduitPrimaire updateProduitPrimaire(ProduitPrimaire produitPrimaire) {
        return produitPrimaireRepository.save(produitPrimaire);
    }

    @Override
    public void deleteProduitPrimaire(Long id) {
        produitPrimaireRepository.deleteById(id);
    }

    @Override
    public ProduitPrimaire getProduitPrimaire(Long id) {
        return produitPrimaireRepository.findById(id).orElseThrow(()->
                new RuntimeException("Produit Primaire not found"));
    }

    @Override
    public ProduitPrimaire getProduitPrimaireByNom(String nom) {
        return produitPrimaireRepository.findByNom(nom);
    }

    @Override
    public List<ProduitPrimaire> getAllProduitsPrimaires() {
        return produitPrimaireRepository.findAll();
    }

    @Override
    public List<ProduitPrimaire> getProduitsPrimairesByType(String type) {
        return produitPrimaireRepository.findByType(type);
    }
}

