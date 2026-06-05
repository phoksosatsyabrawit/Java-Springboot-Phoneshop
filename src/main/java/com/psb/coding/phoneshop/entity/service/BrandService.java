package com.psb.coding.phoneshop.entity.service;

import java.util.Map;

import com.psb.coding.phoneshop.entity.Brand;
import org.springframework.data.domain.Page;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);//return single brand
	Brand update(Integer id, Brand brandUpdate);
	Brand delete(Integer id, Brand brandDelete);
	Page<Brand> getBrands(Map<String, String> params);
}
