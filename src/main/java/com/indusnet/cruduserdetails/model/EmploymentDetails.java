package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
public class EmploymentDetails {
	/**
	 * Eid - employment Id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Eid")
	@SequenceGenerator(name = "Eid", sequenceName = "Eid", initialValue = 72001)
	private Long id;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "employment type must not contains numbers or special characters")
	private String employmentType;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "employment status must not contains numbers or special characters")
	private String employmentStatus;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "natureofwork must not contains numbers or special characters")
	private String natureOfWork;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "employerName must not contains numbers or special characters")
	private String employerName;
	@NotEmpty
	private String employerAddress;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "industry type must not contains numbers or special characters")
	private String industryType;
	
	@OneToOne(mappedBy = "employmentDetails")
	private PersonalDetails personalDetails;

	
	
}
