package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import jakarta.validation.Valid;

public interface IPersonalDetailsService {
	public  List<PersonalDetails> getAllUser();
	public PersonalDetails getPersonUser(long userId);
	public ResponseModel createPersonUser(@Valid PersonalDetails user);
	public ResponseModel updatePersonUser(@Valid PersonalDetails user);
	public ResponseModel deletePersonUser(PersonalDetails user);
}
