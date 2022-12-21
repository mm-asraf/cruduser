package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.ContactDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IContactDetailsService {
	public  List<ContactDetails> getContactDetail();
	public ContactDetails getContactDetail(Long userId);
	public ResponseModel createContactDetail( ContactDetails user);
	public ResponseModel updateContactDetail(ContactDetails person,Long user);
	public ResponseModel deleteContactDetail(Long personalId);
}
