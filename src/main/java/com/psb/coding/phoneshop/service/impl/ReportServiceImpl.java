package com.psb.coding.phoneshop.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.psb.coding.phoneshop.projection.ProductSale;
import com.psb.coding.phoneshop.repository.SaleRepository;
import com.psb.coding.phoneshop.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
	
	private final SaleRepository saleRepository;

	@Override
	public List<ProductSale> getProductSale(LocalDate startDate, LocalDate endDate) {
		LocalDateTime start = startDate.atStartOfDay();
		LocalDateTime end = endDate.atTime(LocalTime.MAX);
		List<ProductSale> productSaleReports = saleRepository.findProductSale(start, end);
		return productSaleReports;
	}
}