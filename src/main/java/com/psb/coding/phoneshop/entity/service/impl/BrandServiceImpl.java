package com.psb.coding.phoneshop.entity.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.entity.pagination.util.PageUtil;
import com.psb.coding.phoneshop.entity.repository.BrandRepository;
import com.psb.coding.phoneshop.entity.service.BrandService;
import com.psb.coding.phoneshop.entity.spec.BrandFilter;
import com.psb.coding.phoneshop.entity.spec.BrandSpec;
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
	public Page<Brand> getBrands(Map<String, String> params) {// build dynamic query statement
		BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		//TODO add to function for pageable
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		
		PageRequest pageRequest = PageUtil.pageRequest(pageNumber, pageLimit);
		
		return brandRepository.findAll(brandSpec, pageRequest);
	}
}
