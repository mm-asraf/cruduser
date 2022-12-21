package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="addressId")
	@SequenceGenerator(name = "addressId", sequenceName = "addressId", initialValue = 5001)
	private Long id;

	@NotEmpty
	private String addressLineFirst;
	@NotEmpty
	private String addressLineSecond;

	private String addressLineThird;

	@NotEmpty
	@Size(max = 30,message = "max character should be 30")
	private String city;

	@NotEmpty
	private String state;

	@NotEmpty
	@Size(min=6,message="min digit should be only 6")
	@Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$")
	private String zipcode;
}
