package tn.esprit.microservice.reclamation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamationRepository extends JpaRepository<Reclamation , Integer> {
}
