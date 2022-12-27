package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.indusnet.cruduserdetails.Repository.IDemoScanPanRepository;
import com.indusnet.cruduserdetails.exception.RecordFoundException;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.DemoScanPan;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IDemoScanPanService;

@Service
public class DemoScanPanImpl implements IDemoScanPanService {
	
	@Autowired
	IDemoScanPanRepository iDemoScanPanRepo;
	
	/**
	 *this method is used for collecting user personal details.
	 */
	@Override
	public ResponseModel createPan(DemoScanPan pan) {
		
		DemoScanPan panDetails = DemoScanPan.builder()
				.name(pan.getName())
				.dateOfBirth(pan.getDateOfBirth())
				.panNumber(pan.getPanNumber())
				.build();
		iDemoScanPanRepo.findByPanNumber(pan.getPanNumber()).ifPresentOrElse(x->{throw new RecordFoundException("already exist"); }, ()->iDemoScanPanRepo.save(panDetails));
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	/**
	 *this method is used for updating user personal details.
	 */
	@Override
	public ResponseModel updatePan(DemoScanPan pan,Long user) {
		iDemoScanPanRepo.findById(user).ifPresentOrElse(x->{
			DemoScanPan updateProfileModel = DemoScanPan.builder()
					.id(user)
					.name(pan.getName())
					.dateOfBirth(pan.getDateOfBirth())
					.build();
			iDemoScanPanRepo.save(updateProfileModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();	
	}
	
	
	/**
	 *this method is used to deleting single user.
	 */
	@Override
	public ResponseModel deletePan(Long panId) {
		iDemoScanPanRepo.findById(panId).ifPresentOrElse(x->{
			iDemoScanPanRepo.deleteById(panId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}

	@Override
	public List<DemoScanPan> getPan() {
		return  (List<DemoScanPan>) iDemoScanPanRepo.findAll();	
	}

	@Override
	public DemoScanPan getPan(Long panId) {
		return iDemoScanPanRepo.findById(panId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}
}
