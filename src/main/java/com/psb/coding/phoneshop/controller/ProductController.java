package com.psb.coding.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psb.coding.phoneshop.dto.ProductDTO;
import com.psb.coding.phoneshop.entity.Product;
import com.psb.coding.phoneshop.mapper.ProductMapper;
import com.psb.coding.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private final ProductMapper productMapper;
	
	@PostMapping
	public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
		Product product = productMapper.toProduct(productDTO);
		product = productService.creat(product);
		return ResponseEntity.ok(product);
	}
}
