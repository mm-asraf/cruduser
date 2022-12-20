package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IUserDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IPersonalDetailsService;

import jakarta.validation.Valid;

@Service
public class PersonalDetailsImpl implements IPersonalDetailsService {
	
	@Autowired
	IUserDetailsRepository iPersonalDetailsRepo;
	

	@Override
	public ResponseModel createPersonUser( PersonalDetails user) {
		PersonalDetails personalDetails = PersonalDetails.builder()
				.dateOfBirth(user.getDateOfBirth())
				.firstName(user.getFirstName())
				.midName(user.getMidName())
				.lastName(user.getLastName())
				.placeOfBirth(user.getPlaceOfBirth())
				.nationality(user.getNationality())
				.build();
		iPersonalDetailsRepo.findByFirstName(user.getFirstName()).ifPresentOrElse(x->{throw new RecordFoundException("already exist"); }, ()->iPersonalDetailsRepo.save(personalDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	
	@Override
	public ResponseModel updatePersonUser(PersonalDetails person,Long user) {
		System.out.println("user id is "+user);
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
	
	@Override
	public List<PersonalDetails> getAllUser() {
		List<PersonalDetails> personDetail = (List<PersonalDetails>) iPersonalDetailsRepo.findAll();
		return personDetail;
	}

	@Override
	public PersonalDetails getPersonUser(Long profileId) {	
		
		
		return iPersonalDetailsRepo.findById(profileId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel deletePersonUser(PersonalDetails user) {
		iPersonalDetailsRepo.findById(user.getId()).ifPresentOrElse(x->{
			iPersonalDetailsRepo.delete(user);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});
		iPersonalDetailsRepo.delete(user);
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

}
