package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IAddressDetailsRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanAadhaarRepository;
import com.indusnet.cruduserdetails.Repository.IDemoScanPanRepository;
import com.indusnet.cruduserdetails.Repository.IOtherPersonalDetailsRepository;
import com.indusnet.cruduserdetails.Repository.IPersonalDetailsRepository;
import com.indusnet.cruduserdetails.dto.AddressDetailsDto;
import com.indusnet.cruduserdetails.dto.OtherPersonalDetailsDto;
import com.indusnet.cruduserdetails.dto.PersonalDetailsDto;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
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

	@Autowired
	IOtherPersonalDetailsRepository iOtherPersonalDetailsRepo;

	@Autowired
	IAddressDetailsRepository iAddressDetailsRepo;

	/**
	 *this method is used for collecting user personal details.
	 */
	@Override
	public ResponseModel createPersonUser( Long personalId) {
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
	public PersonalDetailsDto getPersonUser(Long personalId) {	
		DemoScanAadhaar data = iDemoScanAadhaarRepo.findById(personalId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
		Optional<PersonalDetails> optional = iPersonalDetailsRepo.findById(personalId);

		if(optional.isEmpty())
			return PersonalDetailsDto.builder().id(personalId)
					.firstName(data.getFirstName())
					.midName(data.getMidName())
					.lastName(data.getLastName())
					.dateOfBirth(data.getDateOfBirth())
					.placeOfBirth(data.getCity())
					.nationality("Indian")
					.build();

		else {
			OtherPersonalDetails otherPersonalDetails = optional.get().getOtherPersonalDetails();
			AddressDetails addressDetails = optional.get().getAddressDetails();
			OtherPersonalDetailsDto dto = new OtherPersonalDetailsDto(personalId, 
					otherPersonalDetails.getIncomeProofType(),
					otherPersonalDetails.getIncomeProofNumber(),
					otherPersonalDetails.getAddressProofType(), 
					otherPersonalDetails.getAddressProofNumber(), 
					otherPersonalDetails.getGender(),
					personalId);

			AddressDetailsDto addressDto = new AddressDetailsDto(
					personalId,
					addressDetails.getAddressLineFirst(),
					addressDetails.getAddressLineSecond(),
					addressDetails.getAddressLineThird(), 
					addressDetails.getCity(), 
					addressDetails.getState(), 
					addressDetails.getZipcode(), personalId);
			return PersonalDetailsDto.builder()
					.id(personalId)
					.firstName(data.getFirstName())
					.midName(data.getMidName())
					.lastName(data.getLastName())
					.dateOfBirth(data.getDateOfBirth())
					.placeOfBirth(data.getCity())
					.nationality("Indian")
					.otherPersonalDetails(dto)
					.addressDetails(addressDto)
					.build();
		}
	}
}
