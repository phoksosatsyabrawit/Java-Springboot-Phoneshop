package com.psb.coding.phoneshop.entity.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.psb.coding.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);//return single brand
	Brand update(Integer id, Brand brandUpdate);
	Brand delete(Integer id, Brand brandDelete);
	//List<Brand> getBrands(String name);
	//List<Brand> getBrands(Map<String, String> params); //dynamic query
	Page<Brand> getBrands(Map<String, String> params);
}
