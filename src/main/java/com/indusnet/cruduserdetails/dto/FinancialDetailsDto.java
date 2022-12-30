package com.indusnet.cruduserdetails.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinancialDetailsDto {
	/**
	 * poa-> purpose for opening account
	 * sof-> source of funds 
	 */
	private Long id;
	private String poa;
	private String sof;
	private Long monthlyIncome;
	private String date;
	private Long personalDetails;
}
