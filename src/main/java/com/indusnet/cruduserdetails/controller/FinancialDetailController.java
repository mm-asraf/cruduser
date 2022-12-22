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

import com.indusnet.cruduserdetails.model.EmploymentDetails;
import com.indusnet.cruduserdetails.model.FinancialDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IFinancialDetailsService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0")
public class FinancialDetailController {

	@Autowired
	IFinancialDetailsService iFinancialDetailsService;

	@GetMapping("/financialDetail")
	public List<FinancialDetails> getAllFinancialUser(){
		return this.iFinancialDetailsService.getAllFinancialUser();
	}

	@GetMapping("/financialDetail/{finId}")
	public FinancialDetails getEmploymentDetail(@PathVariable("finId") Long finId) {
		FinancialDetails employeeDetail = iFinancialDetailsService.getFinancialDetail(finId);
		return employeeDetail;	
	}

	@PostMapping("/financialDetail")
	public ResponseEntity<ResponseModel> createEmploymentDetail(@RequestBody @Valid FinancialDetails financialDetail) {
		ResponseModel response = iFinancialDetailsService.createFinancialDetail(financialDetail);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/financialDetail/{finId}")
	public ResponseEntity<ResponseModel> updateEmploymentDetail(@RequestBody @Valid FinancialDetails financialDetail,@PathVariable("empId") Long finId) {
		ResponseModel response = iFinancialDetailsService.updateFinancialDetail(financialDetail, finId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@DeleteMapping("/financialDetail/{finId}")
	public ResponseModel deleteEmploymentDetail(Long finId) {
		ResponseModel response = iFinancialDetailsService.deleteFinancialDetail(finId);	
		return response;
	}
}
