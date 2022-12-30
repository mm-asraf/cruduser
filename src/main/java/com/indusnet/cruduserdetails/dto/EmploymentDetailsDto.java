package com.indusnet.cruduserdetails.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmploymentDetailsDto {
	/**
	 * Eid - employment Id
	 */
	private Long id;
	private String employmentType;
	private String employmentStatus;
	private String natureOfWork;
	private String employerName;
	private String employerAddress;
	private String industryType;
	private Long personalDetails;
}
