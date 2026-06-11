package com.psb.coding.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.psb.coding.phoneshop.entity.Brand;
import com.psb.coding.phoneshop.exception.ResourceNotFoundException;
import com.psb.coding.phoneshop.repository.BrandRepository;
import com.psb.coding.phoneshop.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	
	@Mock
	private BrandRepository brandRepository;
	
	// BrandRepository brandReposoitory = new BrandRepository();
	
	private BrandService brandService;
	
	//public BrandServiceImpl(BrandRepository brandRepository){ this.brandRepository = brandRepository }
	//BrandServiceImpl brandService = new BrandServiceImpl();
	
	@BeforeEach // execute before test
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	
	@Test
	public void testCreate() { //V2
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		//when
		brandService.create(brand);
		//then
		verify(brandRepository, times(1)).save(brand);
	}
	
	@Test
	public void testGetById() {
		//given
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Apple");
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		Brand byIdReturn = brandService.getById(1);
		//then
		assertEquals(1, byIdReturn.getId());
		assertEquals("Apple", byIdReturn.getName());
	}
	
	@Test
	public void testGetByIdThrow() {
		//given
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.empty());
		
		assertThatThrownBy(() -> brandService.getById(1))
		.isInstanceOf(ResourceNotFoundException.class).hasMessage("Brand with id = 1 not found");
		//.hasMessageContaining("not found");
		//.hasMessage("%s with id = %d not found", "Brand", 1);
		//then
	}
	
	@Test
	public void testCreates() { //V1
		//given
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("Apple");
		//when
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.create(new Brand());
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
}
