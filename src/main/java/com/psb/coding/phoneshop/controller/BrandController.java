package com.psb.coding.phoneshop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psb.coding.phoneshop.dto.BrandDTO;
import com.psb.coding.phoneshop.dto.PageDTO;
import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.entity.service.BrandService;
import com.psb.coding.phoneshop.mapper.BrandMapper;

@RestController
@RequestMapping(path = "/brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@PostMapping
	public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand brands = brandService.create(brand);
		return ResponseEntity.ok(brands);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getSingleBrand(@PathVariable Integer id){
		Brand brand = brandService.getById(id);
		return ResponseEntity.ok(brand);
	}
	
	@GetMapping
	public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){ //Use Map<K,V> to resolve multiple parameter
		/*List<BrandDTO> listBrand = brandService.getBrands(params)
		.stream()
		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
		.collect(Collectors.toList());*/
		Page<Brand> pageBrand = brandService.getBrands(params);
		
		PageDTO pageDTO = new PageDTO(pageBrand);
		return ResponseEntity.ok(pageDTO);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateBrand(@PathVariable Integer id, @RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand update = brandService.update(id, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(update));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable Integer id, @RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand delete = brandService.delete(id, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(delete));
	}
}
