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
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IAddressDetailsService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0")
public class AddressDetailController {

	@Autowired
	IAddressDetailsService  iAddressDetailsService;

	@GetMapping("/addessDetail")
	public List<AddressDetails> getAllOtherPersonal(){
		return this.iAddressDetailsService.getAddressDetail();
	}

	@GetMapping("/addessDetail/{addressId}")
	public AddressDetails getOtherPersonal(@PathVariable("addressId") Long addressId) {
		return iAddressDetailsService.getAddressDetail(addressId);
		
	}

	@PostMapping("/addessDetail")
	public ResponseEntity<ResponseModel> createOtherPersonal(@RequestBody @Valid AddressDetails request) {
		ResponseModel response = iAddressDetailsService.createAddressDetail(request);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/addessDetail/{addressId}")
	public ResponseEntity<ResponseModel> updateOtherPersonal(@RequestBody @Valid  AddressDetails addressDetail,@PathVariable("addressId") Long addressId) {
		ResponseModel response = iAddressDetailsService.updateAddressDetail(addressDetail,addressId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@DeleteMapping("/addessDetail/{addressId}")
	public ResponseModel deletePersonUser(@PathVariable("personalId") Long personalId) {		
		ResponseModel response = iAddressDetailsService.deleteAddressDetail(personalId);	
		return response;
	}

}
