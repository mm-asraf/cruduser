package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.indusnet.cruduserdetails.Repository.IFinancialDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.FinancialDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IFinancialDetailsService;

public class FinancialDetailsImpl implements IFinancialDetailsService {

	@Autowired
	IFinancialDetailsRepository iFinancialDetailRepo;

	@Override
	public List<FinancialDetails> getAllFinancialUser() {
		List<FinancialDetails> employeeDetail = (List<FinancialDetails>) iFinancialDetailRepo.findAll();
		return employeeDetail;
	}

	@Override
	public FinancialDetails getFinancialDetail(Long finId) {
		return iFinancialDetailRepo.findById(finId).orElseThrow(()-> {throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createFinancialDetail(FinancialDetails financialDetail) {
		FinancialDetails financialDetails = FinancialDetails.builder()
				.poa(financialDetail.getPoa())
				.sof(financialDetail.getSof())
				.monthlyIncome(financialDetail.getMonthlyIncome())
				.date(financialDetail.getDate())
				.build();
		iFinancialDetailRepo.save(financialDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}
	@Override
	public ResponseModel updateFinancialDetail(FinancialDetails financialDetail, Long finId) {
		iFinancialDetailRepo.findById(finId).ifPresentOrElse(x->{
			FinancialDetails updateAddressModel = FinancialDetails.builder()
					.id(finId)
					.poa(financialDetail.getPoa())
					.sof(financialDetail.getSof())
					.monthlyIncome(financialDetail.getMonthlyIncome())
					.date(financialDetail.getDate())
					.build();
			iFinancialDetailRepo.save(updateAddressModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();	
	}

	@Override
	public ResponseModel deleteFinancialDetail(Long finId) {
		iFinancialDetailRepo.findById(finId).ifPresentOrElse(x->{
			iFinancialDetailRepo.deleteById(finId);
		}, ()-> {throw new RecordNotFoundException("Invalid id Not found");});	
		return ResponseModel.builder().message("data deleted successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();
	}
}
