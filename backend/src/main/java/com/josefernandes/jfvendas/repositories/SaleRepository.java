package com.josefernandes.jfvendas.repositories;

import com.josefernandes.jfvendas.dtos.SaleSuccessDTO;
import com.josefernandes.jfvendas.dtos.SaleSumDTO;
import com.josefernandes.jfvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.josefernandes.jfvendas.dtos.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupBySaler();

    @Query("SELECT new com.josefernandes.jfvendas.dtos.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successRateGroupBySaler();

}
