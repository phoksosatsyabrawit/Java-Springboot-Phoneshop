package com.psb.coding.phoneshop.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GeneralUtilsTest {

	@Test
	public void toIntegerTest() {
		//given
		List<String> names = List.of("Bravit", "Mark", "Bill");
		//when
		List<Integer> list = GeneralUtil.toInteger(names);
		//then
		assertEquals(3, list.size());
		assertEquals(6, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(4, list.get(2));
	}
	
	@Test
	public void listOfEvenNumberTest() {
		//given
		List<Integer> numbers = List.of(4, 6, 8, 20, 3, 7, 9, 18);
		//when
		List<Integer> evenNumber = GeneralUtil.listOfEvenNumber(numbers);
		//then
		assertEquals(5, evenNumber.size());
		assertEquals(4, evenNumber.get(0));
	}
}
