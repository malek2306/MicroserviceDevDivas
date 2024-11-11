package ms.produitp.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ms.produitp.Entities.Enums.TypeProduitPrimaire;
import ms.produitp.Entities.Enums.UniteMesure;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProduitPrimaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String description;
    int quantite;
    double prixUnitaire;
    @Enumerated(EnumType.STRING)
    UniteMesure uniteMesure;
    @Enumerated(EnumType.STRING)
    TypeProduitPrimaire type;
    // String image;

}