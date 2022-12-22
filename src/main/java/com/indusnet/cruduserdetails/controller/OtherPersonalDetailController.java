package com.indusnet.cruduserdetails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IOtherPersonalDetailsService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0")
public class OtherPersonalDetailController {

	@Autowired
	IOtherPersonalDetailsService iOtherPersonalDetailsService;

	@GetMapping("/otherpersonal")
	public List<OtherPersonalDetails> getAllOtherPersonal(){
		return this.iOtherPersonalDetailsService.getAllOtherPersonal();
	}

	@GetMapping("/otherpersonal/{userId}")
	public OtherPersonalDetails getOtherPersonal(@PathVariable("userId") Long userId) {
		return iOtherPersonalDetailsService.getOtherPersonal(userId);
	}

	@PostMapping("/otherpersonal")
	public ResponseEntity<ResponseModel> createOtherPersonal(@RequestBody @Valid OtherPersonalDetails request) {
		ResponseModel response = iOtherPersonalDetailsService.createOtherPersonal(request);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/personalDetails/{otherpersonalId}")
	public ResponseEntity<ResponseModel> updateOtherPersonal(OtherPersonalDetails person, Long userId) {
		ResponseModel response = iOtherPersonalDetailsService.updateOtherPersonal(person,userId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}	
}
