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
import com.indusnet.cruduserdetails.dto.AddressDetailsDto;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IAddressDetailsService;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v0/addessDetail")
public class AddressDetailController {

	@Autowired
	IAddressDetailsService  iAddressDetailsService;

	@GetMapping
	public List<AddressDetails> getAllOtherPersonal(){
		return this.iAddressDetailsService.getAddressDetail();
	}

	@GetMapping("/{addressId}")
	public AddressDetailsDto getOtherPersonal(@PathVariable("addressId") Long addressId) {
		return iAddressDetailsService.getAddressDetail(addressId);	
	}

	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseModel> createOtherPersonal(@PathVariable("addressId") Long addressId) {
		ResponseModel response = iAddressDetailsService.createAddressDetail(addressId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}

	@PutMapping("/{addressId}")
	public ResponseEntity<ResponseModel> updateOtherPersonal(@RequestBody @Valid  AddressDetails addressDetailRequest,@PathVariable("addressId") Long addressId) {
		ResponseModel response = iAddressDetailsService.updateAddressDetail(addressDetailRequest,addressId);
		HttpStatus status = response.getStatusCode() != null ? response.getStatusCode() : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(response,status);
	}
}
