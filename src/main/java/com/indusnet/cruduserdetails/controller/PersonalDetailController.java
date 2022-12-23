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

import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IPersonalDetailsService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/personalDetails")
public class PersonalDetailController {

	@Autowired
	IPersonalDetailsService iPersonalDetailService;

	@GetMapping
	public List<PersonalDetails> getPersonUser() {	
		return this.iPersonalDetailService.getAllUser();
	}

	@GetMapping("/{personalId}")
	public PersonalDetails getPersonUser(@PathVariable("personalId") Long personalId) {		
		return iPersonalDetailService.getPersonUser(personalId);		
	}

	@DeleteMapping("/{personalId}")
	public ResponseModel deletePersonUser(@PathVariable("personalId") Long personalId) {		
		return iPersonalDetailService.deletePersonUser(personalId);	
	}

	@PostMapping
	public ResponseEntity<ResponseModel> createPersonUser( @RequestBody @Valid PersonalDetails request) {
		ResponseModel response = iPersonalDetailService.createPersonUser(request);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/{personalId}")
	public ResponseEntity<ResponseModel> updatePersonUser(  @RequestBody @Valid PersonalDetails request,@PathVariable("personalId") Long personalId) {
		ResponseModel response = iPersonalDetailService.updatePersonUser(request,personalId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}	
}
