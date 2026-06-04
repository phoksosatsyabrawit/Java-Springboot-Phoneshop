package com.psb.coding.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand brands = brandService.create(brand);
		return ResponseEntity.ok(brands);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getSingleBrand(@PathVariable Integer id){
		Brand brand = brandService.getById(id);
		return ResponseEntity.ok(brand);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable Integer id, @RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand update = brandService.update(id, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(update));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable Integer id, @RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand delete = brandService.delete(id, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(delete));
	}
}
