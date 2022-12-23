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
import com.indusnet.cruduserdetails.model.FinancialDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IFinancialDetailsService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/financialDetail")
public class FinancialDetailController {

	@Autowired
	IFinancialDetailsService iFinancialDetailsService;

	@GetMapping
	public List<FinancialDetails> getAllFinancialUser(){
		return this.iFinancialDetailsService.getAllFinancialUser();
	}

	@GetMapping("/{finId}")
	public FinancialDetails getEmploymentDetail(@PathVariable("finId") Long finId) {
		return iFinancialDetailsService.getFinancialDetail(finId);
			
	}

	@PostMapping
	public ResponseEntity<ResponseModel> createEmploymentDetail(@RequestBody @Valid FinancialDetails financialDetailRequest) {
		ResponseModel response = iFinancialDetailsService.createFinancialDetail(financialDetailRequest);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/{finId}")
	public ResponseEntity<ResponseModel> updateEmploymentDetail(@RequestBody @Valid FinancialDetails financialDetailRequest,@PathVariable("empId") Long finId) {
		ResponseModel response = iFinancialDetailsService.updateFinancialDetail(financialDetailRequest, finId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@DeleteMapping("/financialDetail/{finId}")
	public ResponseModel deleteEmploymentDetail(Long finId) {
		return iFinancialDetailsService.deleteFinancialDetail(finId);	
	}
}
