package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Column;
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
public class OtherPersonalDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="otherPersonalUserId")
	@SequenceGenerator(name = "otherPersonalUserId", sequenceName = "otherPersonalUserId", initialValue = 5001)
	private Long id;
	@NotEmpty
	@Size(max = 25,message = "max character should be 25")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Income Proof type  must not contains numbers or special characters")
	private String incomeProofType;
	@NotEmpty
	@Column(unique=true)
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Income Proof type  must not contains numbers or special characters")
	private String incomeProofNumber;
	@NotEmpty
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Income Proof type  must not contains numbers or special characters")
	private String addressProofType;
	@NotEmpty
	@Column(unique=true)
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$", message = "Income Proof type  must not contains numbers or special characters")
	private String addressProofNumber;
	@NotEmpty
	@Size(max = 15,message = "min character should be 10")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Income Proof type  must not contains numbers or special characters")
	private String gender;
}
