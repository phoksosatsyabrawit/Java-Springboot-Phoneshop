package com.psb.coding.phoneshop.entity.service;

import com.psb.coding.phoneshop.entity.Brand;
import java.util.List;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);//return single brand
	Brand update(Integer id, Brand brandUpdate);
	Brand delete(Integer id, Brand brandDelete);
	List<Brand> getBrands();
	List<Brand> getBrands(String name);
}
