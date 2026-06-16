package com.psb.coding.phoneshop.service;

import com.psb.coding.phoneshop.entity.Product;

public interface ProductService {

	Product creat(Product product);
	Product getById(Long id);
}
