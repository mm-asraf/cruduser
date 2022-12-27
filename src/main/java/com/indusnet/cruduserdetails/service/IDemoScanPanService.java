package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IDemoScanPanService {
	public  List<DemoScanPan> getPan();
	public DemoScanPan getPan(Long panId);
	public ResponseModel createPan( DemoScanPan pan);
	public ResponseModel updatePan(DemoScanPan pan,Long panId);
	public ResponseModel deletePan(Long panId);
}
