package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IContactDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.ContactDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IContactDetailsService;

@Service
public class ContactDetailsImpl implements IContactDetailsService {

	@Autowired
	IContactDetailsRepository iContactDetailsRepo;

	@Override
	public List<ContactDetails> getContactDetail() {
		List<ContactDetails> personDetail = (List<ContactDetails>) iContactDetailsRepo.findAll();
		return personDetail;
	}

	@Override
	public ContactDetails getContactDetail(Long contactId) {
		return iContactDetailsRepo.findById(contactId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createContactDetail(ContactDetails contact) {
		ContactDetails personalDetails = ContactDetails.builder()
				.mobile(contact.getMobile())
				.email(contact.getEmail())
				.build();
		iContactDetailsRepo.findByMobile(contact.getMobile()).ifPresentOrElse(x->{throw new RecordFoundException("already exist"); },
				()->iContactDetailsRepo.save(personalDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}

	@Override
	public ResponseModel updateContactDetail(ContactDetails contact, Long contactId) {
		iContactDetailsRepo.findById(contactId).ifPresentOrElse(x->{
			ContactDetails updateContactModel = ContactDetails.builder()
					.id(contactId)
					.mobile(contact.getMobile())
					.email(contact.getEmail())
					.build();
			iContactDetailsRepo.save(updateContactModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();		
	}

	@Override
	public ResponseModel deleteContactDetail(Long contactId) {
		iContactDetailsRepo.findById(contactId).ifPresentOrElse(x->{
			iContactDetailsRepo.deleteById(contactId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}
}


