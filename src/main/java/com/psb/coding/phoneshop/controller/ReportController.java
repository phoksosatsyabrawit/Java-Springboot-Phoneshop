package com.psb.coding.phoneshop.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psb.coding.phoneshop.projection.ProductSale;
import com.psb.coding.phoneshop.service.ReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
	
	private final ReportService reportService;
	
	@GetMapping("/productSale")
	public ResponseEntity<?> getProductSaleReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
		List<ProductSale> productSaleReports = reportService.getProductSale(startDate, endDate);
		return ResponseEntity.ok(productSaleReports);
	}
}
