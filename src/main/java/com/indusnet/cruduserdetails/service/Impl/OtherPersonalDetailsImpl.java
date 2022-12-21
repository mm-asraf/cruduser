package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IOtherPersonalDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IOtherPersonalDetailsService;

@Service
public class OtherPersonalDetailsImpl implements IOtherPersonalDetailsService {

	@Autowired
	IOtherPersonalDetailsRepository iOtherPersonalDetails;

	@Override
	public List<OtherPersonalDetails> getAllOtherPersonal() {
		List<OtherPersonalDetails> personDetail = (List<OtherPersonalDetails>) iOtherPersonalDetails.findAll();
		return personDetail;
	}

	@Override
	public OtherPersonalDetails getOtherPersonal(Long userId) {			
		return iOtherPersonalDetails.findById(userId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createOtherPersonal(OtherPersonalDetails user) {
		OtherPersonalDetails otherpersonalDetail = OtherPersonalDetails.builder()
				.incomeProofType(user.getIncomeProofNumber())
				.incomeProofNumber(user.getIncomeProofNumber())
				.addressProofType(user.getAddressProofType())
				.addressProofNumber(user.getAddressProofNumber())
				.gender(user.getGender())
				.build();
		iOtherPersonalDetails.findByIncomeProofNumber(user.getIncomeProofNumber())
		.ifPresentOrElse(x->{throw new RecordFoundException("already exist"); },
				()->iOtherPersonalDetails.save(otherpersonalDetail));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();


	}

	@Override
	public ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long userId) {
		iOtherPersonalDetails.findById(userId).ifPresentOrElse(x->{
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
