package com.psb.coding.phoneshop.service;

import java.util.List;

import com.psb.coding.phoneshop.dto.PriceDTO;
import com.psb.coding.phoneshop.dto.ProductDTO;
import com.psb.coding.phoneshop.dto.ProductImportHistoryDTO;
import com.psb.coding.phoneshop.entity.Product;

public interface ProductService {

	Product creat(Product product);
	Product getById(Long id);
	List<ProductDTO> getProducts();
	void imports(ProductImportHistoryDTO productHistoryDto);
	void setSalePrice(Long id, PriceDTO priceDto);
}
