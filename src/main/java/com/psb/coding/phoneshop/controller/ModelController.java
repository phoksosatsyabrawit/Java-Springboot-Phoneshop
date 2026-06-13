package com.psb.coding.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psb.coding.phoneshop.dto.ModelDTO;
import com.psb.coding.phoneshop.entity.Model;
import com.psb.coding.phoneshop.mapper.ModelMapper;
import com.psb.coding.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController { // inject dependency through constructor

	private final ModelService modelService;
	/*private final ModelMapper modelMapper;*/
	
	@PostMapping
	public ResponseEntity<?> createModel(@RequestBody ModelDTO modelDTO){
		/*Model model = modelService.save(modelMapper.toModel(modelDTO));*/
		Model model = modelService.save(modelDTO);
		return ResponseEntity.ok(model);
	}
}
