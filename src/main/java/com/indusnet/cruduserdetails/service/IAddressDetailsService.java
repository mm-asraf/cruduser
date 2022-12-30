package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.dto.AddressDetailsDto;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IAddressDetailsService {
	public  List<AddressDetails> getAddressDetail();
	public AddressDetailsDto getAddressDetail(Long addressId);
	public ResponseModel createAddressDetail( Long addressId);
	public ResponseModel updateAddressDetail(AddressDetails address,Long addressId);
}
