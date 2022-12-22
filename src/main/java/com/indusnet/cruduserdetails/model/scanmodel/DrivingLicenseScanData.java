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
public class DrivingLicenseScanData {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="aadhaarId")
	@SequenceGenerator(name = "aadhaarId", sequenceName = "aadhaarId", initialValue = 9001)
	private Long id;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="", message = "")
	private String licenseNumber;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Name must not contains numbers or special characters")
	private String name;
	
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "name must not contains numbers or special characters")
	private String fathersName;
	
	@NotEmpty
	@Size(message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "address must not contains numbers or special characters")
	private String address;

}
