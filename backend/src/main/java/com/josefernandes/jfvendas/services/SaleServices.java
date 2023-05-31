package com.josefernandes.jfvendas.services;

import com.josefernandes.jfvendas.dtos.SaleDTO;
import com.josefernandes.jfvendas.entities.Sale;
import com.josefernandes.jfvendas.repositories.SaleRepository;
import com.josefernandes.jfvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleServices {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepo;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){
        //para resolver um problema desnecessario de ida ao banco buscar seller, agora vai ir só uma vez
        sellerRepo.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }



}
