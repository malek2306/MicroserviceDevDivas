package ms.produitp.Services;

import ms.produitp.Entities.ProduitPrimaire;

import java.util.List;

public interface IProduitPrimaireService {
    ProduitPrimaire addProduitPrimaire(ProduitPrimaire produitPrimaire);
    ProduitPrimaire updateProduitPrimaire(ProduitPrimaire produitPrimaire);
    void deleteProduitPrimaire(Long id);
    ProduitPrimaire getProduitPrimaire(Long id);
    ProduitPrimaire getProduitPrimaireByNom(String nom);

    List<ProduitPrimaire> getAllProduitsPrimaires();
    List<ProduitPrimaire> getProduitsPrimairesByType(String type);
}

