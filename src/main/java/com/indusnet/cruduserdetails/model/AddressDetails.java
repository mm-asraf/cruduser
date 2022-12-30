package com.indusnet.cruduserdetails.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class AddressDetails {
	@Id
	private Long id;
	@NotEmpty
	private String addressLineFirst;
	@NotEmpty
	private String addressLineSecond;
	private String addressLineThird;
	@NotEmpty
	@Size(max = 30,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "city must not contains numbers or special characters")
	private String city;
	@NotEmpty//[a-zA-Z]{3,12}
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "state must not contains numbers or special characters")
	private String state;
	@NotEmpty
	@Size(min=6,message="min digit should be only 6")
	@Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message="should not start with 0 or it should contains 6 digit format 556898 or 555 888")
	private String zipcode;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PersonalDetails personalDetails;

}
