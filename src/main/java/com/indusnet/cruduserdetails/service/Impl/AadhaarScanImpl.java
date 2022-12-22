package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.indusnet.cruduserdetails.Repository.ScanRepository.IAadhaarScanRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.AadhaarScanData;
import com.indusnet.cruduserdetails.service.IAadhaarScanService;

public class AadhaarScanImpl implements IAadhaarScanService {

	@Autowired
	IAadhaarScanRepository iAadhaarScanRepo;

	@Override
	public List<AadhaarScanData> getAadhaarDetail() {
		return (List<AadhaarScanData>) iAadhaarScanRepo.findAll();	
	}

	@Override
	public AadhaarScanData getAadhaarDetail(Long addressId) {
		return iAadhaarScanRepo.findById(addressId).orElseThrow(()-> {throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createAadhaarDetail(AadhaarScanData aadhaar) {
		AadhaarScanData aadhaarDetails = AadhaarScanData.builder()
				.name(aadhaar.getName())
				.fathersName(aadhaar.getFathersName())
				.dateOfBirth(aadhaar.getAadhaarNumber())
				.aadhaarNumber(aadhaar.getAadhaarNumber())
				.address(aadhaar.getAddress())
				.build();
		iAadhaarScanRepo.findByAadhaarNumber(aadhaar.getAadhaarNumber()).ifPresentOrElse(x->{throw new RecordFoundException("already exist"); },
				()->iAadhaarScanRepo.save(aadhaarDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();			
	}
}
