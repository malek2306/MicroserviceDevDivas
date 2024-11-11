package com.microservice.livraison.Repositories;

import com.microservice.livraison.Entities.Livraison;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;

public interface LivraisonRepository extends JpaRepository<Livraison,Integer > {

}

