package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IDemoScanAadhaarService {
	public  List<DemoScanAadhaar> getAadhaarScan();
	public DemoScanAadhaar getAadhaarScan(Long aId);
	public ResponseModel createAadhaarScan( DemoScanAadhaar aadhaar);
	public ResponseModel updateAadhaarScan(DemoScanAadhaar aadhaar,Long aId);
	public ResponseModel deleteAadhaarScan(Long aId);
}
