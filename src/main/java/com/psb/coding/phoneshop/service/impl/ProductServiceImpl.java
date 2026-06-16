package com.psb.coding.phoneshop.service.impl;


import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.entity.Product;
import com.psb.coding.phoneshop.exception.ResourceNotFoundException;
import com.psb.coding.phoneshop.repository.ProductRepository;
import com.psb.coding.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

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
}
