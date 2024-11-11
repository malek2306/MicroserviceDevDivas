package ms.produitp.Repositories;

import ms.produitp.Entities.ProduitPrimaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitPrimaireRepository extends JpaRepository<ProduitPrimaire, Long> {
    List<ProduitPrimaire> findByType(String type);
    ProduitPrimaire findByNom(String nom);
}