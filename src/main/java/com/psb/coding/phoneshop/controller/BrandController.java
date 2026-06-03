package com.psb.coding.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psb.coding.phoneshop.dto.BrandDTO;
import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.entity.service.BrandService;
import com.psb.coding.phoneshop.entity.service.util.Mapper;

@RestController
@RequestMapping(path = "/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<?> responseEntity(@RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand brands = brandService.create(brand);
		return ResponseEntity.ok(brands);
	}
}
