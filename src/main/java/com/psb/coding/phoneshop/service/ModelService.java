package com.psb.coding.phoneshop.service;

import com.psb.coding.phoneshop.dto.ModelDTO;
import com.psb.coding.phoneshop.entity.Model;

public interface ModelService {
	Model save(ModelDTO modelDTO);
}
