package com.indusnet.cruduserdetails.Repository.ScanRepository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.scanmodel.PanScanData;

@Repository
public interface IPanScanRepository extends CrudRepository<PanScanData,Long> {
	Optional<PanScanData> findByPanNumber(String panNumber);
}
