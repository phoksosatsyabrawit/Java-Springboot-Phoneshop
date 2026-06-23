package com.psb.coding.phoneshop.service;

import java.time.LocalDate;
import java.util.List;

import com.psb.coding.phoneshop.projection.ProductSale;

public interface ReportService {

	List<ProductSale> getProductSale(LocalDate startDate, LocalDate endDate);
}
