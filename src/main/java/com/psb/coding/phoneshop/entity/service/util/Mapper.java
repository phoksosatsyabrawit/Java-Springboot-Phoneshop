package com.psb.coding.phoneshop.entity.service.util;

import com.psb.coding.phoneshop.dto.BrandDTO;
import com.psb.coding.phoneshop.entity.Brand;

public class Mapper {

	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}
}
