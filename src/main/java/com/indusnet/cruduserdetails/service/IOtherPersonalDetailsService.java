package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.dto.OtherPersonalDetailsDto;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IOtherPersonalDetailsService {
	public  List<OtherPersonalDetails> getAllOtherPersonal();
	public OtherPersonalDetailsDto getOtherPersonal(Long otherPersonalId);
	public ResponseModel createOtherPersonal(Long otherPersonalId);
	public ResponseModel deleteOtherPersonal(Long otherPersonalId);
	ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long otherPersonalId);
	
}
