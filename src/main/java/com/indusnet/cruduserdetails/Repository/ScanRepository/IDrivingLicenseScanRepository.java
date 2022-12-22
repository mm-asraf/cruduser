package com.indusnet.cruduserdetails.Repository.ScanRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.scanmodel.DrivingLicenseScanData;

@Repository
public interface IDrivingLicenseScanRepository extends CrudRepository<DrivingLicenseScanData,Long> {
	Optional<DrivingLicenseScanData> findByDrivingLicenseNumber(String licenseNumber);
}
