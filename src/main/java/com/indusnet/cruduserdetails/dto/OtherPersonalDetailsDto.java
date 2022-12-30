package com.indusnet.cruduserdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtherPersonalDetailsDto {
	private Long id;
	private String incomeProofType;
	private String incomeProofNumber;
	private String addressProofType;
	private String addressProofNumber;
	private String gender;
	private Long personalDetails;	
}
