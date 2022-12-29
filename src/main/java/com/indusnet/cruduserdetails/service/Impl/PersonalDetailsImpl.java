package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanPanRepository;
import com.indusnet.cruduserdetails.Repository.IPersonalDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IPersonalDetailsService;


/**
 * this class contains all methods for service implementations. 
 */
@Service
public class PersonalDetailsImpl implements IPersonalDetailsService {
	

	
	@Autowired
	IPersonalDetailsRepository iPersonalDetailsRepo;
	
	@Autowired
	IDemoScanPanRepository iDemoScanPanRepository;
	
	@Autowired
	IDemoScanAadhaarRepository iDemoScanAadhaarRepo;
	
	/**
	 *this method is used for collecting user personal details.

	 */
	
//	PersonalDetails personalDetails;
	
	@Override
	public ResponseModel createPersonUser( Long personalId) {
		
//		Optional<DemoScanPan> dbpan = iDemoScanPanRepository.findById(id);
//		Optional<DemoScanAadhaar> optional = iDemoScanAadhaarRepo.findById(id);
//		if(optional.isPresent() ) {
//			DemoScanAadhaar dbadhaar = optional.get();
//			 personalDetails = PersonalDetails.builder()
//					.firstName(dbadhaar.getFirstName())
//					.midName(dbadhaar.getMidName())
//					.lastName(dbadhaar.getLastName())
//					.dateOfBirth(dbadhaar.getDateOfBirth())
//					.placeOfBirth(dbadhaar.getCity())
//					.nationality("Indian")
//					
//					.build();
//			 iPersonalDetailsRepo.save(personalDetails);
//		}else {
//			throw new RecordNotFoundException("pan card doesn't exits in db");
//		}		
//		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
		
		
		Optional<DemoScanAadhaar> findById = iDemoScanAadhaarRepo.findById(personalId);
		
		if(findById.isPresent()) {
			DemoScanAadhaar data = findById.get();
			PersonalDetails personalDetails = PersonalDetails.builder().id(personalId)
					.firstName(data.getFirstName())
					.midName(data.getMidName())
					.lastName(data.getLastName())
					.dateOfBirth(data.getDateOfBirth())
					.placeOfBirth(data.getCity())
					.nationality("Indian")
					.build();	
			iPersonalDetailsRepo.save(personalDetails);
		}
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	/**
	 *this method is used for updating user personal details.
	 */
	@Override
	public ResponseModel updatePersonUser(PersonalDetails person,Long user) {
		iPersonalDetailsRepo.findById(user).ifPresentOrElse(x->{
			PersonalDetails updateProfileModel = PersonalDetails.builder()
					.id(user)
					.firstName(person.getFirstName())
					.lastName(person.getLastName())
					.midName(person.getMidName())
					.nationality(person.getNationality())
					.placeOfBirth(person.getPlaceOfBirth())
					.dateOfBirth(person.getDateOfBirth())
					.build();
			iPersonalDetailsRepo.save(updateProfileModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();	
	}
	
	/**
	 *this method is used for getting all users with their personal details.
	 */
	@Override
	public List<PersonalDetails> getAllUser() {
		return  (List<PersonalDetails>) iPersonalDetailsRepo.findAll();
	}

	/**
	 *this method is used for getting single user with their personal details.
	 */
	@Override
	public PersonalDetails getPersonUser(Long personalId) {	
		DemoScanAadhaar data = iDemoScanAadhaarRepo.findById(personalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		
		
		
		return PersonalDetails.builder().id(personalId)
				.firstName(data.getFirstName())
				.midName(data.getMidName())
				.lastName(data.getLastName())
				.dateOfBirth(data.getDateOfBirth())
				.placeOfBirth(data.getCity())
				.nationality("Indian")
				.build();
		
	}

	/**
	 *this method is used to deleting single user.
	 */
	@Override
	public ResponseModel deletePersonUser(Long userId) {
		iPersonalDetailsRepo.findById(userId).ifPresentOrElse(x->{
			iPersonalDetailsRepo.deleteById(userId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}
}
