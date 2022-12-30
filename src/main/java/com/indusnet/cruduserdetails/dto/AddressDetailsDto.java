package com.indusnet.cruduserdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDetailsDto {
	private Long id;
	private String addressLineFirst;
	private String addressLineSecond;
	private String addressLineThird;
	private String city;
	private String state;
	private String zipcode;
	private Long personalDetails;
}
