package com.indusnet.cruduserdetails.model.scanmodel;

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
public class PanScanData {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="aadhaarId")
	@SequenceGenerator(name = "aadhaarId", sequenceName = "aadhaarId", initialValue = 8001)
	private long id;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Name must not contains numbers or special characters")
	private String name;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Name must not contains numbers or special characters")
	private String fathersName;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "date of birth of must contain this format like this yyyy-mm-dd")
	private String dateOfBirth;
	
	@NotEmpty
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}",message="pan number should contains five alphabet then ")
	private String panNumber;
}
