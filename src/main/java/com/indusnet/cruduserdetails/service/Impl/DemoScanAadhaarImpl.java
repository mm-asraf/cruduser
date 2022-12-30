package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IDemoScanAadhaarService;

@Service
public class DemoScanAadhaarImpl implements IDemoScanAadhaarService {

	@Autowired
	IDemoScanAadhaarRepository iDemoScanAadhaarRepo;

	@Override
	public List<DemoScanAadhaar> getAadhaarScan() {	
		return (List<DemoScanAadhaar>) iDemoScanAadhaarRepo.findAll();
	}

	@Override
	public DemoScanAadhaar getAadhaarScan(Long aId) {
		return iDemoScanAadhaarRepo.findById(aId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createAadhaarScan(DemoScanAadhaar aadhaar) {
		DemoScanAadhaar aadhaarDetails = DemoScanAadhaar.builder()
				.firstName(aadhaar.getFirstName())
				.midName(aadhaar.getLastName())
				.lastName(aadhaar.getLastName())
				.fatherName(aadhaar.getFatherName())
				.dateOfBirth(aadhaar.getDateOfBirth())
				.city(aadhaar.getCity())
				.aadhaarNumber(aadhaar.getAadhaarNumber())
				.zipcode(aadhaar.getZipcode())
				.state(aadhaar.getState())
				.address(aadhaar.getAddress())
				.build();
		iDemoScanAadhaarRepo.save(aadhaarDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();			
	}

	@Override
	public ResponseModel updateAadhaarScan(DemoScanAadhaar aadhaar, Long aId) {	
		return null;
	}

	@Override
	public ResponseModel deleteAadhaarScan(Long aId) {	
		return null;
	}


}
