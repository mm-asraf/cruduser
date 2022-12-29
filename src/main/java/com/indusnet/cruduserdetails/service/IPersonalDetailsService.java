package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

/**
 * this class contains all services for user personalDetails;
 */
public interface IPersonalDetailsService {
	public  List<PersonalDetails> getAllUser();
	public PersonalDetails getPersonUser(Long userId);
	public ResponseModel createPersonUser(Long personalId);
	public ResponseModel updatePersonUser(PersonalDetails person,Long user);
	public ResponseModel deletePersonUser(Long personalId);
}
