package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indusnet.cruduserdetails.model.ContactDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IContactDetailsService;

@Service
public class ContactDetailsImpl implements IContactDetailsService {

	@Override
	public List<ContactDetails> getContactDetail() {
		
		return null;
	}

	@Override
	public ContactDetails getContactDetail(Long userId) {
		
		return null;
	}

	@Override
	public ResponseModel createContactDetail(ContactDetails user) {
		
		return null;
	}

	@Override
	public ResponseModel updateContactDetail(ContactDetails person, Long user) {
		
		return null;
	}

	@Override
	public ResponseModel deleteContactDetail(Long personalId) {
		
		return null;
	}
	
}


