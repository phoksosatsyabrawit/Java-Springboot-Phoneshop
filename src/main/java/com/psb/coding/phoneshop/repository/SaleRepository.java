package com.psb.coding.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psb.coding.phoneshop.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

}
