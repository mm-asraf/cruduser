package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IAddressDetailsService {
	public  List<AddressDetails> getAddressDetail();
	public AddressDetails getAddressDetail(Long userId);
	public ResponseModel createAddressDetail( AddressDetails user);
	public ResponseModel updateAddressDetail(AddressDetails person,Long user);
	public ResponseModel deleteAddressDetail(Long personalId);
}
