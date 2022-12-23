package com.indusnet.cruduserdetails.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Income Proof type  must not contains numbers or special characters")
	private String incomeProofType;
	@NotEmpty
	@Column(unique=true)
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Income Proof type or pan card must not contains numbers or special characters")
	private String incomeProofNumber;
	@NotEmpty
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "address Proof type or aadhaar  must not contains numbers or special characters")
	private String addressProofType;
	@NotEmpty
	@Column(unique=true)
	@Size(min = 10,message = "min character should be 10")
	@Pattern(regexp="/(^[0-9]{4}[0-9]{4}[0-9]{4}$)|(^[0-9]{4}\s[0-9]{4}\s[0-9]{4}$)|(^[0-9]{4}-[0-9]{4}-[0-9]{4}$)/", message = "Income Proof type or aadhaar must follow indian aadhaar format system")
	private String addressProofNumber;
	@NotEmpty
	@Size(max = 15,message = "max character should be 15")
	@Pattern(regexp="[a-zA-Z]{2,12}", message = "Income Proof type  must not contains numbers or special characters")
	private String gender;
	@OneToOne(mappedBy = "otherPersonalDetails")
	private PersonalDetails personalDetails;
}
