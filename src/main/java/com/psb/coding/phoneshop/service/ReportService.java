package com.psb.coding.phoneshop.service;

import java.time.LocalDate;
import java.util.List;

import com.psb.coding.phoneshop.dto.ProductReportDTO;
import com.psb.coding.phoneshop.projection.ProductSale;

public interface ReportService {

	List<ProductSale> getProductSale(LocalDate startDate, LocalDate endDate);
	List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate);
}
