package com.psb.coding.phoneshop.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

	/*@InjectMocks
	private ReportServiceImpl reportService;
	@Mock
	private SaleRepository saleRepository;
	@Mock
	private SaleDetailRepository saleDetailRepository;
	@Mock
	private ProductImportHistoryRepository productImportHistoryRepository;
	@Mock
	private ProductRepository productRepository;

	@Test
	public void testGetExpenseReport() {
		// given
		List<ProductImportHistory> importHist = getImportHistList();
		// when
		when(productImportHistoryRepository.findAll(Mockito.any(ProductImportHistorySpec.class))).thenReturn(importHist);
		when(productRepository.findById(1L)).thenReturn(Optional.of(product1()));
		var result = reportService.getExpenseReport(LocalDate.now().minusMonths(1L), LocalDate.now());
		// then
		assertEquals(1, result.size());
	}
	
	public static Product product1(){
		Product product = new Product();
		product.setId(1L);
		product.setName("iphone 14 pro");
		return product;
	}
	
	private static List<ProductImportHistory> getImportHistList(){
		List<ProductImportHistory> piList = new ArrayList<>()
		var importHist = new ProductImportHistory();
		importHist.setProduct(product1());
		importHist.setImportUnit(10);
		importHist.setPricePerUnit(BigDecimal.valueOf(12000));
		importHist.setImportDate(LocalDateTime.of(2026, 6, 20, 10, 25));
		piList.add(importHist);
		return piList;
	}*/
}
