package com.psb.coding.phoneshop.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.dto.PriceDTO;
import com.psb.coding.phoneshop.dto.ProductDTO;
import com.psb.coding.phoneshop.dto.ProductImportHistoryDTO;
import com.psb.coding.phoneshop.entity.Product;
import com.psb.coding.phoneshop.entity.ProductImportHistory;
import com.psb.coding.phoneshop.exception.ResourceNotFoundException;
import com.psb.coding.phoneshop.mapper.ProductMapper;
import com.psb.coding.phoneshop.repository.ProductImportHistoryRepository;
import com.psb.coding.phoneshop.repository.ProductRepository;
import com.psb.coding.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository productImportHistoryRepository;
	private final ProductMapper productMapper;
	
	@Override
	public Product creat(Product product) {
		String productName = "%s %s".formatted(
				product.getModel().getName(), 
				product.getColor().getName());
		product.setName(productName);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}

	@Override
	public List<ProductDTO> getProducts() {
		List<ProductDTO> productList = productRepository.findAll()
				.stream()
				.map(product -> productMapper.toProductDto(product))
				.toList();
		return productList;
	}

	@Override
	public void imports(ProductImportHistoryDTO productHistoryDto) {
		// save & update product available_unit
		Product product = getById(productHistoryDto.getProductId());
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(availableUnit + productHistoryDto.getImportUnit());
		productRepository.save(product);
		// save import history
		ProductImportHistory importProduct = productMapper.toProductImportHistory(productHistoryDto);
		productImportHistoryRepository.save(importProduct);
	}

	@Override
	public void setSalePrice(Long id, PriceDTO priceDto) {
		Product product = getById(id);
		product.setSalePrice(priceDto.getSalePrice());
		productRepository.save(product);
	}
}
