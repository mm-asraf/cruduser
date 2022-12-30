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
import com.indusnet.cruduserdetails.dto.OtherPersonalDetailsDto;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IOtherPersonalDetailsService;

@Service
public class OtherPersonalDetailsImpl implements IOtherPersonalDetailsService {

	@Autowired
	IOtherPersonalDetailsRepository iOtherPersonalDetailsRepo;

	@Autowired
	IPersonalDetailsRepository iPersonalDetailsRepo;

	@Autowired
	IDemoScanPanRepository iDemoScanPanRepo;

	@Autowired
	IDemoScanAadhaarRepository iDemoScanAadhaarRepo;

	@Override
	public List<OtherPersonalDetails> getAllOtherPersonal() {
		return (List<OtherPersonalDetails>) iOtherPersonalDetailsRepo.findAll();	
	}

	@Override
	public OtherPersonalDetailsDto getOtherPersonal(Long otherPersonalId) {
		DemoScanPan pandata = iDemoScanPanRepo.findById(otherPersonalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		DemoScanAadhaar aadhaarData = iDemoScanAadhaarRepo.findById(otherPersonalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});

		Optional<OtherPersonalDetails> optional = iOtherPersonalDetailsRepo.findById(otherPersonalId);

		if(optional.isEmpty())
			return OtherPersonalDetailsDto.builder()
					.id(otherPersonalId)
					.addressProofType("Aadhaar card")
					.addressProofNumber(aadhaarData.getAadhaarNumber())
					.incomeProofType("pan card")
					.incomeProofNumber(pandata.getPanNumber())
					.gender("Male")
					.build();

		else
			return OtherPersonalDetailsDto.builder()
					.id(otherPersonalId)
					.addressProofType(optional.get().getAddressProofType())
					.addressProofNumber(optional.get().getAddressProofNumber())
					.incomeProofType(optional.get().getIncomeProofType())
					.incomeProofNumber(optional.get().getIncomeProofNumber())
					.gender(optional.get().getGender())
					.personalDetails(optional.get().getId())
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
				.id(otherPersonalId)
				.incomeProofType("PAN")
				.incomeProofNumber(data.getPanNumber())
				.addressProofType("Aadhaar")
				.addressProofNumber(aadharData.getAadhaarNumber())
				.gender("Male")
				.personalDetails(personalDetails)
				.build();
		OtherPersonalDetails save = iOtherPersonalDetailsRepo.save(otherPersonalDetail);	
		personalDetails.setOtherPersonalDetails(save);
		iPersonalDetailsRepo.save(personalDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	@Override
	public ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long otherPersonalId) {
		iOtherPersonalDetailsRepo.findById(otherPersonalId).ifPresentOrElse(x->{
			OtherPersonalDetails updatedOtherPersonalDetails = OtherPersonalDetails.builder()
					.incomeProofType(person.getAddressProofType())
					.incomeProofNumber(person.getAddressProofNumber())
					.addressProofType(person.getAddressProofNumber())
					.gender(person.getGender())
					.build();	
			iOtherPersonalDetailsRepo.save(updatedOtherPersonalDetails);
		}, ()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();
	}

	@Override
	public ResponseModel deleteOtherPersonal(Long otherPersonalId) {
		iOtherPersonalDetailsRepo.findById(otherPersonalId).ifPresentOrElse(x->{
			iOtherPersonalDetailsRepo.deleteById(otherPersonalId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}
}
