package com.psb.coding.phoneshop.service;

import java.util.List;

import com.psb.coding.phoneshop.dto.ModelDTO;
import com.psb.coding.phoneshop.entity.Model;

public interface ModelService {
	Model save(ModelDTO modelDTO);
	Model getById(Integer id);
	List<Model> getModels();
	Model update(Integer id, ModelDTO modelUpdate);
	Model delete(Integer id);
}
