package com.psb.coding.phoneshop.entity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.entity.repository.BrandRepository;
import com.psb.coding.phoneshop.entity.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
}
