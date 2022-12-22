package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.AadhaarScanData;

public interface IAadhaarScanService{
	public  List<AadhaarScanData> getAadhaarDetail();
	public AadhaarScanData getAadhaarDetail(Long addressId);
	public ResponseModel createAadhaarDetail( AadhaarScanData aadhaar);
}
