package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.PanScanData;

public interface IPanScanService {
	public  List<PanScanData> getPanScanDetail();
	public PanScanData getPanScanDetail(Long panId);
	public ResponseModel createPanScanDetail( PanScanData panscan);
}
