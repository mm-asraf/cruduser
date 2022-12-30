package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.indusnet.cruduserdetails.Repository.IAddressDetailsRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.Repository.IPersonalDetailsRepository;
import com.indusnet.cruduserdetails.dto.AddressDetailsDto;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IAddressDetailsService;

@Service
public class AddressDetailImpl implements IAddressDetailsService{

	@Autowired
	IAddressDetailsRepository iAddressDetailsRepo;

	@Autowired
	IDemoScanAadhaarRepository iDemoScanAadhaarRepo;

	@Autowired
	IPersonalDetailsRepository iPersonalDetailsRepo;

	@Override
	public List<AddressDetails> getAddressDetail() {
		return (List<AddressDetails>) iAddressDetailsRepo.findAll();
	}

	@Override
	public AddressDetailsDto getAddressDetail(Long userId) {
		DemoScanAadhaar aadhaarData = iDemoScanAadhaarRepo.findById(userId).orElseThrow(()-> {throw new RecordNotFoundException("not available");});
		Optional<AddressDetails> optional = iAddressDetailsRepo.findById(userId); 
		if(optional.isEmpty()) 
			return AddressDetailsDto.builder()
					.id(userId)
					.addressLineFirst("adressline 1")
					.addressLineSecond("addressLineSecond")
					.addressLineThird("addressline third")
					.city(aadhaarData.getCity())
					.state(aadhaarData.getState())
					.zipcode(aadhaarData.getZipcode())
					.build();

		else
			return AddressDetailsDto.builder()
					.id(userId)
					.addressLineFirst("adressline 1")
					.addressLineSecond("addressLineSecond")
					.addressLineThird("addressline third")
					.city(aadhaarData.getCity())
					.state(aadhaarData.getState())
					.zipcode(aadhaarData.getZipcode())
					.personalDetails(optional.get().getId())
					.build();

	}

	@Override
	public ResponseModel createAddressDetail(Long addressId) {

		DemoScanAadhaar aadhaarData = iDemoScanAadhaarRepo.findById(addressId).orElseThrow(()-> {throw new RecordNotFoundException("not available");});
		Optional<PersonalDetails> optPersonalDetails = iPersonalDetailsRepo.findById(addressId);

		PersonalDetails personalDetails = null;
		if(optPersonalDetails.isPresent()) {
			personalDetails = optPersonalDetails.get();
		}

		AddressDetails addressDetails = AddressDetails.builder()
				.id(addressId)
				.addressLineFirst("fist adddress line")
				.addressLineSecond("address line second")
				.addressLineThird("address line third")
				.city(aadhaarData.getCity())
				.state(aadhaarData.getState())
				.zipcode(aadhaarData.getZipcode())
				.personalDetails(personalDetails)
				.build();
		AddressDetails saveAddress = iAddressDetailsRepo.save(addressDetails);
		personalDetails.setAddressDetails(saveAddress);
		iPersonalDetailsRepo.save(personalDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}

	@Override
	public ResponseModel updateAddressDetail(AddressDetails address, Long addressId) {
		iAddressDetailsRepo.findById(addressId).ifPresentOrElse(x->{
			AddressDetails updateAddressModel = AddressDetails.builder()
					.id(addressId)
					.addressLineFirst(address.getAddressLineFirst())
					.addressLineSecond(address.getAddressLineSecond())
					.addressLineThird(address.getAddressLineThird())
					.city(address.getCity())
					.state(address.getState())
					.zipcode(address.getZipcode())
					.build();
			iAddressDetailsRepo.save(updateAddressModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();	

	}
}
