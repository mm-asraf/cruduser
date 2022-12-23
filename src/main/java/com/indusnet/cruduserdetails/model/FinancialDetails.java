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
public class FinancialDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="financialId")
	@SequenceGenerator(name = "financialId", sequenceName = "financialId", initialValue = 45001)
	private Long id;
	
	/**
	 * poa-> purpose for opening account
	 * sof-> source of funds 
	 */
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "poa must not contains numbers or special characters")
	private String poa;
	@NotEmpty
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "poa must not contains numbers or special characters")
	private String sof;
	@NotEmpty
	@Pattern(regexp="\\p{Digit}+",message="it should contains digits only")
	private Long monthlyIncome;
	@NotEmpty
	@Pattern(regexp="^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", message = "date must contain this format like this yyyy-mm-dd")
	private String date;
	
	@OneToOne(mappedBy = "financialDetails")
	private PersonalDetails personalDetails;
	
}
