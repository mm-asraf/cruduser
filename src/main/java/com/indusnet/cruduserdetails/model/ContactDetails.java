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
public class ContactDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="contactId")
	@SequenceGenerator(name = "contactId", sequenceName = "contactId", initialValue = 6001)
	private Long id;
	
	@Column(unique=true)
	@Size(min=10,max=10,message="mobile number should be 10 charecter")
	@Pattern(regexp ="(0/91)?[7-9][0-9]{9}",message="Enter valid Mobile Number")
	private String mobile;
	
	@NotEmpty
	@Column(unique=true)
	@Size(max = 35,message = "min character should be 3")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "email should not contain special character but valid email style will be fine")
	private String email;
}
