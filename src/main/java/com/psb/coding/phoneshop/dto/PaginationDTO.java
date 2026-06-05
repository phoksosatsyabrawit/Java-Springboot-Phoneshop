package com.psb.coding.phoneshop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
	private Integer pageSize;
	private Integer pageNumber;
	private Integer totalPages;
	private Long totalElements;
	private Integer numberOfElements;

	private boolean first;
	private boolean last;
	private boolean empty;
}
