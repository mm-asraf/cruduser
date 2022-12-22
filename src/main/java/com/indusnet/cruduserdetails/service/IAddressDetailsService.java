package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IAddressDetailsService {
	public  List<AddressDetails> getAddressDetail();
	public AddressDetails getAddressDetail(Long addressId);
	public ResponseModel createAddressDetail( AddressDetails address);
	public ResponseModel updateAddressDetail(AddressDetails address,Long addressId);
	public ResponseModel deleteAddressDetail(Long addressId);
}
