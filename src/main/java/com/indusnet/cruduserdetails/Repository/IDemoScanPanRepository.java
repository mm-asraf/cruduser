package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.indusnet.cruduserdetails.model.DemoScanPan;

public interface IDemoScanPanRepository extends CrudRepository<DemoScanPan, Long>{
	Optional<DemoScanPan> findByPanNumber(String pancardNumber);
}
