package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.indusnet.cruduserdetails.model.DemoScanAadhaar;

public interface IDemoScanAadhaarRepository extends CrudRepository<DemoScanAadhaar, Long> {
	Optional<DemoScanAadhaar> findByAadhaarNumber(String aadhaarNumber);
}
