package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.indusnet.cruduserdetails.Repository.IAddressDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IAddressDetailsService;

public class AddressDetailImpl implements IAddressDetailsService{

	@Autowired
	IAddressDetailsRepository iAddressDetailsRepo;

	@Override
	public List<AddressDetails> getAddressDetail() {
		return (List<AddressDetails>) iAddressDetailsRepo.findAll();
	}

	@Override
	public AddressDetails getAddressDetail(Long userId) {
		return iAddressDetailsRepo.findById(userId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});

	}

	@Override
	public ResponseModel createAddressDetail(AddressDetails address) {
		AddressDetails addressDetails = AddressDetails.builder()
				.addressLineFirst(address.getAddressLineFirst())
				.addressLineSecond(address.getAddressLineSecond())
				.addressLineThird(address.getAddressLineThird())
				.city(address.getCity())
				.state(address.getState())
				.zipcode(address.getZipcode())
				.build();
		iAddressDetailsRepo.save(addressDetails);
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

	@Override
	public ResponseModel deleteAddressDetail(Long addressId) {
		iAddressDetailsRepo.findById(addressId).ifPresentOrElse(x->{
			iAddressDetailsRepo.deleteById(addressId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();

	}

}
