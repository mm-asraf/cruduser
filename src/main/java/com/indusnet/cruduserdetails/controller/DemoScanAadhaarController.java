package com.indusnet.cruduserdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IDemoScanAadhaarService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/aadhaarScan")
public class DemoScanAadhaarController {
	
	@Autowired
	IDemoScanAadhaarService iDemoAadhaarService;

	@PostMapping
	public ResponseEntity<ResponseModel> createAadhaarScan(@RequestBody @Valid DemoScanAadhaar aadhaarRequest) {
		ResponseModel response = iDemoAadhaarService.createAadhaarScan(aadhaarRequest);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}
	
	
	@GetMapping("/{personalId}")
	public DemoScanAadhaar getPersonUser(@PathVariable("personalId") Long personalId) {		
		return iDemoAadhaarService.getAadhaarScan(personalId);		
	}
	
}
