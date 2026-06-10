package com.psb.coding.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.psb.coding.phoneshop.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	
	@Autowired
	private BrandRepository brandRepository;

	@Test
	public void findByNameLikeTest() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brandRepository.save(brand);
		//when
		List<Brand> listBrand = brandRepository.findByNameLike("%A%");
		//then
		assertEquals(1, listBrand.size());
		assertEquals(1, listBrand.get(0).getId());
		assertEquals("Apple", listBrand.get(0).getName());
	}
	
	@Test
	public void findByNameContainingTest() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setName("Samsung");
		brandRepository.save(brand);
		//when
		List<Brand> byNameContaining = brandRepository.findByNameContaining("s");
		//then
		assertEquals(1, byNameContaining.size());
		assertEquals(2, byNameContaining.get(0).getId());
		assertEquals("Samsung", byNameContaining.get(0).getName());
	}
}
