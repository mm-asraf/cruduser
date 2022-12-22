package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.indusnet.cruduserdetails.Repository.ScanRepository.IPanScanRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.model.scanmodel.PanScanData;
import com.indusnet.cruduserdetails.service.IPanScanService;

public class PanScanImpl implements IPanScanService{

	@Autowired
	IPanScanRepository iPanScanRepo;
	
	@Override
	public List<PanScanData> getPanScanDetail() {	
		 return (List<PanScanData>) iPanScanRepo.findAll();
	}

	@Override
	public PanScanData getPanScanDetail(Long panId) {	
		return  iPanScanRepo.findById(panId).orElseThrow(()-> {throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createPanScanDetail(PanScanData panscan) {
		PanScanData panDetails = PanScanData.builder()
				.name(panscan.getName())
				.fathersName(panscan.getFathersName())
				.dateOfBirth(panscan.getDateOfBirth())
				.panNumber(panscan.getPanNumber())
				.build();
		iPanScanRepo.findByPanNumber(panscan.getPanNumber()).ifPresentOrElse(x->{throw new RecordFoundException("already exist"); },
				()->iPanScanRepo.save(panDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();				
	}

}
