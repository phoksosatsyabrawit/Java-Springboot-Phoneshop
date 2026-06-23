package com.psb.coding.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psb.coding.phoneshop.entity.Product;
import com.psb.coding.phoneshop.entity.ProductImportHistory;

@Repository
public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory, Long> {

	List<ProductImportHistory> findByProductId(Long productId);
}
