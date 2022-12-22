package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.DrivingLicenseScanData;

public interface IDrivingLicenseScanService {
	public  List<DrivingLicenseScanData> getDrivingLicenseDetail();
	public DrivingLicenseScanData getDrivingLicenseDetail(Long drivingId);
	public ResponseModel createDrivingLicenseDetail( DrivingLicenseScanData drivingLicense);
	public ResponseModel updateDrivingLicenseDetail(DrivingLicenseScanData drivingLicense,Long drivingId);
	public ResponseModel deleteDrivingLicenseDetail(Long drivingId);
}
