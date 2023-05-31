package com.josefernandes.jfvendas.repositories;

import com.josefernandes.jfvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SaleRepository extends JpaRepository<Sale, Long> {
}
