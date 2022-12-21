package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.PersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

import jakarta.validation.Valid;

public interface IOtherPersonalDetailsService {
	public  List<OtherPersonalDetails> getAllOtherPersonal();
	public OtherPersonalDetails getOtherPersonal(Long userId);
	public ResponseModel createOtherPersonal(OtherPersonalDetails user);
	public ResponseModel deleteOtherPersonal(Long otherPersonalId);
	ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long userId);
	
}
