package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PersonalDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="personaluserid")
	@SequenceGenerator(name = "personaluserid", sequenceName = "personaluserid", initialValue = 2001)
	private Long id;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "First Name must not contains numbers or special characters")
	private String firstName;
	
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "Mid Name must not contains numbers or special characters")
	private String midName;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String lastName;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "date of birth of must contain this format like this yyyy-mm-dd")
	private String dateOfBirth;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	private String placeOfBirth;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	private String nationality;
}
