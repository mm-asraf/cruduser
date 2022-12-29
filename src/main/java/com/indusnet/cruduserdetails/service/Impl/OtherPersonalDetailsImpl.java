package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanPanRepository;
import com.indusnet.cruduserdetails.Repository.IOtherPersonalDetailsRepository;
import com.indusnet.cruduserdetails.Repository.IPersonalDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.OtherPersonalDetailsDto;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IOtherPersonalDetailsService;

@Service
public class OtherPersonalDetailsImpl implements IOtherPersonalDetailsService {

	@Autowired
	IOtherPersonalDetailsRepository iOtherPersonalDetails;
	
	@Autowired
	IPersonalDetailsRepository iPersonalDetailsRepo;
	
	@Autowired
	IDemoScanPanRepository iDemoScanPanRepo;
	
	@Autowired
	IDemoScanAadhaarRepository iDemoScanAadhaarRepo;

	@Override
	public List<OtherPersonalDetails> getAllOtherPersonal() {
		return (List<OtherPersonalDetails>) iOtherPersonalDetails.findAll();	
	}

	@Override
	public OtherPersonalDetailsDto getOtherPersonal(Long otherPersonalId) {
		DemoScanPan data = iDemoScanPanRepo.findById(otherPersonalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		DemoScanAadhaar aadharData = iDemoScanAadhaarRepo.findById(otherPersonalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		return OtherPersonalDetailsDto.builder()
				.id(otherPersonalId)
				.incomeProofType("PAN")
				.incomeProofNumber(data.getPanNumber())
				.addressProofType("Aadhaar")
				.addressProofNumber(aadharData.getAadhaarNumber())
				.gender("Male")
				.personalDetails(otherPersonalId)
				.build();
	}

	@Override
	public ResponseModel createOtherPersonal(Long otherPersonalId) {
		
		Optional<DemoScanPan> findById = iDemoScanPanRepo.findById(otherPersonalId);
		DemoScanAadhaar aadharData = iDemoScanAadhaarRepo.findById(otherPersonalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		DemoScanPan data = findById.get();
		Optional<PersonalDetails> optPersonalDetails = iPersonalDetailsRepo.findById(otherPersonalId);
		
		PersonalDetails personalDetails = null;
		if(optPersonalDetails.isPresent()) {
			personalDetails = optPersonalDetails.get();
		}
		
		OtherPersonalDetails otherPersonalDetail = OtherPersonalDetails.builder()
				.incomeProofType("PAN")
				.incomeProofNumber(data.getPanNumber())
				.addressProofType("Aadhaar")
				.addressProofNumber(aadharData.getAadhaarNumber())
				.gender("Male")
				.personalDetails(personalDetails)
				.build();
		OtherPersonalDetails save = iOtherPersonalDetails.save(otherPersonalDetail);	
		personalDetails.setOtherPersonalDetails(save);
		iPersonalDetailsRepo.save(personalDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	@Override
	public ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long otherPersonalId) {
		iOtherPersonalDetails.findById(otherPersonalId).ifPresentOrElse(x->{
			OtherPersonalDetails updatedOtherPersonalDetails = OtherPersonalDetails.builder()
					.incomeProofType(person.getAddressProofType())
					.incomeProofNumber(person.getAddressProofNumber())
					.addressProofType(person.getAddressProofNumber())
					.gender(person.getGender())
					.build();	
			iOtherPersonalDetails.save(updatedOtherPersonalDetails);
		}, ()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();
	}

	@Override
	public ResponseModel deleteOtherPersonal(Long otherPersonalId) {
		iOtherPersonalDetails.findById(otherPersonalId).ifPresentOrElse(x->{
			iOtherPersonalDetails.deleteById(otherPersonalId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}
}
