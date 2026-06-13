package com.psb.coding.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.psb.coding.phoneshop.dto.ModelDTO;
import com.psb.coding.phoneshop.entity.Model;
import com.psb.coding.phoneshop.service.BrandService;


@Mapper(componentModel = "spring", uses = {BrandService.class})
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(source = "brandId", target = "brand")
	Model toModel(ModelDTO dto);
	
	/*default Brand toBrand(Integer brnId) {
		Brand brand = new Brand();
		brand.setId(brnId);
		return brand;
	}*/
}
