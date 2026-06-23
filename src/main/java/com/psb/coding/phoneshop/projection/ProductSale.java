package com.psb.coding.phoneshop.projection;

import java.math.BigDecimal;

public interface ProductSale {// SPRING DATA HANDLES MAPPING AUTOMATICALLY

	Long getProductId();
	String getProductName();
	Long getUnit();
	BigDecimal getTotalAmount();
}
