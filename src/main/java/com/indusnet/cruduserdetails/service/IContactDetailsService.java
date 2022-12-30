package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.ContactDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IContactDetailsService {
	public  List<ContactDetails> getContactDetail();
	public ContactDetails getContactDetail(Long contactId);
	public ResponseModel createContactDetail( ContactDetails contact);
	public ResponseModel updateContactDetail(ContactDetails contact,Long contactId);
}
