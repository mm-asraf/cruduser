package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import jakarta.validation.Valid;

public interface IPersonalDetailsService {
	public  List<PersonalDetails> getAllUser();
	public PersonalDetails getPersonUser(Long userId);
	public ResponseModel createPersonUser( PersonalDetails user);
	public ResponseModel updatePersonUser(PersonalDetails person,Long user);
	public ResponseModel deletePersonUser(PersonalDetails user);
}
