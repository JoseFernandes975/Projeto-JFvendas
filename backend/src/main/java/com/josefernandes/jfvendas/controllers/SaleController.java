package com.josefernandes.jfvendas.controllers;

import com.josefernandes.jfvendas.dtos.SaleDTO;
import com.josefernandes.jfvendas.dtos.SaleSuccessDTO;
import com.josefernandes.jfvendas.dtos.SaleSumDTO;
import com.josefernandes.jfvendas.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleServices services;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> page = services.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountBySeller(){
        List<SaleSumDTO> result = services.amountGroupSeller();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/success-rate-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successRateBySeller(){
        List<SaleSuccessDTO> result = services.successRate();
        return ResponseEntity.ok(result);
    }


}
