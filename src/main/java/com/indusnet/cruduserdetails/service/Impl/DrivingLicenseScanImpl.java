package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.indusnet.cruduserdetails.Repository.ScanRepository.IDrivingLicenseScanRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.DrivingLicenseScanData;
import com.indusnet.cruduserdetails.service.IDrivingLicenseScanService;

public class DrivingLicenseScanImpl implements IDrivingLicenseScanService {

	@Autowired
	IDrivingLicenseScanRepository iDrivingLicenseScanRepo;

	@Override
	public List<DrivingLicenseScanData> getDrivingLicenseDetail() {	
		return (List<DrivingLicenseScanData>) this.iDrivingLicenseScanRepo.findAll();
	}

	@Override
	public DrivingLicenseScanData getDrivingLicenseDetail(Long drivingId) {	
		return iDrivingLicenseScanRepo.findById(drivingId).orElseThrow(()-> {throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createDrivingLicenseDetail(DrivingLicenseScanData drivingLicense) {
		DrivingLicenseScanData aadhaarDetails = DrivingLicenseScanData.builder()
				.name(drivingLicense.getName())
				.fathersName(drivingLicense.getFathersName())
				.licenseNumber(drivingLicense.getLicenseNumber())
				.address(drivingLicense.getAddress())
				.build();
		iDrivingLicenseScanRepo.findByDrivingLicenseNumber(drivingLicense.getLicenseNumber())
		.ifPresentOrElse(x->{throw new RecordFoundException("already exist");},
				()->iDrivingLicenseScanRepo.save(aadhaarDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();			

	}

}
