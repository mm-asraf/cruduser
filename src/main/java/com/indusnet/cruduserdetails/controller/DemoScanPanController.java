package com.indusnet.cruduserdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IDemoScanPanService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/panDetails")
public class DemoScanPanController {

	@Autowired
	IDemoScanPanService iDemoScanPanService;
	
	@PostMapping
	public ResponseEntity<ResponseModel> createContactDetail(@RequestBody @Valid DemoScanPan panRequest) {
		ResponseModel response = iDemoScanPanService.createPan(panRequest);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}
}
