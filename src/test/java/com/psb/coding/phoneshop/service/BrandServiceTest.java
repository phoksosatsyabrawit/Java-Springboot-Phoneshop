package com.psb.coding.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	private BrandService brandService;
	
	@BeforeEach
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	
	@Test
	public void testCreate() {
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
		brand.setName("Apple");
		brand.setId(1);
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1);
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
		
	}
	
	@Test
	public void testGetByIdThrow() {
		//given
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		//Brand returnById = brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2))
		.isInstanceOf(ResourceNotFoundException.class)
		.hasMessage("Brand with id = 2 not found");
		//.hasMessage(String.format("%s With id = %d not found", "Brand", 2));
		//.hasMessageContaining("not found");
		//then
	}
	
	/*@Test
	public void createTest() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		//when
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandReturn = brandService.create(new Brand());
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}*/
}
