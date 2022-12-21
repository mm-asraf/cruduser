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
public class FinancialDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="financialId")
	@SequenceGenerator(name = "financialId", sequenceName = "financialId", initialValue = 5001)
	private Long id;
	
	/**
	 * poa-> purpose for opening account
	 * sof-> source of funds 
	 */
	@NotEmpty
	private String poa;
	@NotEmpty
	private String sof;
	@NotEmpty
	private Long monthlyIncome;
	@NotEmpty
	private String date;
	
}
