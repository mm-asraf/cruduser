package com.indusnet.cruduserdetails.Repository.ScanRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indusnet.cruduserdetails.model.scanmodel.AadhaarScanData;

@Repository
public interface IAadhaarScanRepository extends CrudRepository<AadhaarScanData, Long> {
	Optional<AadhaarScanData> findByAadhaarNumber(String aadhaarNumber);
}
