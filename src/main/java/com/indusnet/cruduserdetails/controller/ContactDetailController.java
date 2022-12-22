package com.indusnet.cruduserdetails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.cruduserdetails.model.ContactDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IContactDetailsService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0")
public class ContactDetailController {

	@Autowired
	IContactDetailsService iContactDetailService;

	@GetMapping("/contactDetails")
	public  List<ContactDetails> getContactDetail() {
		return this.iContactDetailService.getContactDetail();
	}

	@GetMapping("/contactDetails/{contactId}")
	public ContactDetails getContactDetail(@PathVariable("contactId") Long contactId) {
		ContactDetails contactDetail = iContactDetailService.getContactDetail(contactId);
		return contactDetail;
	}

	@PostMapping("/contactDetails")
	public ResponseEntity<ResponseModel> createContactDetail(@RequestBody @Valid ContactDetails contactRequest) {
		ResponseModel response = iContactDetailService.createContactDetail(contactRequest);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/contactDetails/{contactId}")
	public ResponseEntity<ResponseModel> updateContactDetail(@RequestBody @Valid  ContactDetails contact,@PathVariable("contactId") Long contactId) {
		ResponseModel response = iContactDetailService.updateContactDetail(contact, contactId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);	
	}

	@DeleteMapping("contactDetails/{contactId}")
	public ResponseModel deletePersonUser(@PathVariable("contactId") Long contactId) {		
		ResponseModel response = iContactDetailService.deleteContactDetail(contactId);	
		return response;
	}


}
