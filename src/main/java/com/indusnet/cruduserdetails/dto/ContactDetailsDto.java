package com.indusnet.cruduserdetails.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ContactDetailsDto {
	private Long id;
	private String mobile;
	private String email;
	private Long personalDetails;
}
