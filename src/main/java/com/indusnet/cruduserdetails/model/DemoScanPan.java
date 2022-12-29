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
public class DemoScanPan {

	
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="contactId")
//	@SequenceGenerator(name = "contactId", sequenceName = "contactId", initialValue = 99501)
	@Id
	private Long id;
	
	@NotEmpty
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message="pan card should be valid")
	private String panNumber;
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "Name must not contains numbers or special characters")
	private String name;
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "date of birth of must contain this format like this yyyy-mm-dd")
	private String dateOfBirth;
}
