package com.indusnet.cruduserdetails.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PersonalDetailsDto {
	private Long id;
	private String firstName;
	private String midName;
	private String lastName;
	private String dateOfBirth;
	private String placeOfBirth;
	private String nationality;
	private OtherPersonalDetailsDto otherPersonalDetails;
	private Long contactDetails;
	private AddressDetailsDto addressDetails;
	private Long financialDetails;	
	private Long employmentDetails;	
}
