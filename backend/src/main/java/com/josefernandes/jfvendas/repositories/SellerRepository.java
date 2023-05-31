package com.josefernandes.jfvendas.repositories;

import com.josefernandes.jfvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SellerRepository extends JpaRepository<Seller, Long> {
}
