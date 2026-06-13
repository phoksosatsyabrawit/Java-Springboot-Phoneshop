package com.psb.coding.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.dto.ModelDTO;
import com.psb.coding.phoneshop.entity.Model;
import com.psb.coding.phoneshop.mapper.ModelMapper;
import com.psb.coding.phoneshop.repository.ModelRepository;
import com.psb.coding.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService { // inject through constructor
	
	
	private final ModelRepository modelRepository;
	private final ModelMapper modelMapper;
	
	/*private BrandService brandService;*/

	@Override
	public Model save(ModelDTO modelDTO) {
		/*Integer brandId = model.getBrand().getId();
		brandService.getById(brandId);*/
		Model model = modelMapper.toModel(modelDTO);
		return modelRepository.save(model);
	}

}
