package com.psb.coding.phoneshop.entity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.entity.repository.BrandRepository;
import com.psb.coding.phoneshop.entity.service.BrandService;
import com.psb.coding.phoneshop.exception.ResourceNotFoundException;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
	
	@Override
	public Brand getById(Integer id) {
		/*Optional<Brand> brandOptional = brandRepository.findById(id);
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = %d not found".formatted(id));
		*/
		return brandRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); //@TODO improve update
		return brandRepository.save(brand);
	}

	@Override
	public Brand delete(Integer id, Brand brandDelete) {
		Brand brand = getById(id);
		brandRepository.delete(brandDelete);
		return brand;
	}

	@Override
	public List<Brand> getBrands() {
		return brandRepository.findAll();
	}

	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameIgnoreCase(name);
	}
}
