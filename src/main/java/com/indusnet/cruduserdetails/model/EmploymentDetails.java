package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
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
	@SequenceGenerator(name = "Eid", sequenceName = "Eid", initialValue = 6001)
	private Long id;
	@NotEmpty
	private String employmentType;
	@NotEmpty
	private String employmentStatus;
	@NotEmpty
	private String natureOfWork;
	@NotEmpty
	private String employerName;
	@NotEmpty
	private String employerAddress;
	@NotEmpty
	private String industryType;
	
}
