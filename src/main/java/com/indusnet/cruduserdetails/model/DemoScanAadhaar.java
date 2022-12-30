package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class DemoScanAadhaar {
	

	@Id
	private Long id;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "first name must not contains numbers or special characters")
	private String firstName;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "mid name must not contains numbers or special characters")
	private String midName;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "last name must not contains numbers or special characters")
	private String lastName;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "city must not contains numbers or special characters")
	private String fatherName;
	@NotEmpty
	@Size(min=12,message="aadhar number should contains 12 digits of numbers")
	@Pattern(regexp="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$",message="aadhaar number should be like this 4589 6985 3695")
	private String aadhaarNumber;
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "date of birth of must contain this format like this yyyy-mm-dd")
	private String dateOfBirth;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "name must not contains numbers or special characters")
	private String city;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "state must not contains numbers or special characters")
	private String state;
	@NotEmpty
	@Size(min=6,message="min digit should be only 6")
	@Pattern(regexp="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$",message="should not start with 0 or it should contains 6 digit format 556898 or 555 888")
	private String zipcode;
	@NotEmpty
	@Size(max = 40,message = "max character should be 30")
	private String address;
}
