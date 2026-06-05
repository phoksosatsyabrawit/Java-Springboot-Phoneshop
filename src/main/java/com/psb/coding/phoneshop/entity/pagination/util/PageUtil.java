package com.psb.coding.phoneshop.entity.pagination.util;

import org.springframework.data.domain.PageRequest;

public interface PageUtil {
	Integer DEFAULT_PAGE_LIMIT = 10;
	Integer DEFAULT_PAGE_NUMBER = 1;
	String PAGE_LIMIT = "_limit";
	String PAGE_NUMBER = "_page";

	static PageRequest pageRequest(Integer pageNumber, Integer pageSize) {
		if(pageNumber < DEFAULT_PAGE_NUMBER) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		if(pageSize < 1) {
			pageSize = DEFAULT_PAGE_LIMIT;
		}
		return PageRequest.of(pageNumber-1, pageSize);
	}
}
