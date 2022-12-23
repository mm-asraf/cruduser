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
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IEmploymentDetailsService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/employeeDetail")
public class EmployeeDetailController {

	@Autowired
	IEmploymentDetailsService iEmployeeDetailService;

	@GetMapping
	public  List<EmploymentDetails> getEmploymentDetail(){
		return this.iEmployeeDetailService.getEmploymentDetail();
	}

	@GetMapping("/{empId}")
	public EmploymentDetails getEmploymentDetail(@PathVariable("empId") Long empId) {
		return iEmployeeDetailService.getEmploymentDetail(empId);		
	}

	@PostMapping
	public ResponseEntity<ResponseModel> createEmploymentDetail(@RequestBody @Valid EmploymentDetails employeeDetailRequest) {
		ResponseModel response = iEmployeeDetailService.createEmploymentDetail(employeeDetailRequest);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<ResponseModel> updateEmploymentDetail(@RequestBody @Valid EmploymentDetails employeeDetailRequest,@PathVariable("empId") Long empId) {
		ResponseModel response = iEmployeeDetailService.updateEmploymentDetail(employeeDetailRequest, empId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode():HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@DeleteMapping("/{empId}")
	public ResponseModel deleteEmploymentDetail(Long empId) {
		return iEmployeeDetailService.deleteEmploymentDetail(empId);	
	}
}
