package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.OtherPersonalDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IOtherPersonalDetailsService {
	public  List<OtherPersonalDetails> getAllOtherPersonal();
	public OtherPersonalDetails getOtherPersonal(Long otherPersonalId);
	public ResponseModel createOtherPersonal(OtherPersonalDetails user);
	public ResponseModel deleteOtherPersonal(Long otherPersonalId);
	ResponseModel updateOtherPersonal(OtherPersonalDetails person, Long otherPersonalId);
	
}
