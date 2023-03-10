package com.indusnet.cruduserdetails.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.indusnet.cruduserdetails.Repository.IEmployementDetailsRepository;
import com.indusnet.cruduserdetails.exception.RecordNotFoundException;
import com.indusnet.cruduserdetails.model.EmploymentDetails;
import com.indusnet.cruduserdetails.model.common.MessageTypeConst;
import com.indusnet.cruduserdetails.model.common.ResponseModel;
import com.indusnet.cruduserdetails.service.IEmploymentDetailsService;

@Service
public class EmploymentDetailsImpl implements IEmploymentDetailsService {

	@Autowired
	IEmployementDetailsRepository iEmployementDetailsRepo;

	@Override
	public List<EmploymentDetails> getEmploymentDetail() {
		return (List<EmploymentDetails>) iEmployementDetailsRepo.findAll();	
	}

	@Override
	public EmploymentDetails getEmploymentDetail(Long empId) {
		return iEmployementDetailsRepo.findById(empId).orElseThrow(()->{throw new RecordNotFoundException("not availble");});
	}

	@Override
	public ResponseModel createEmploymentDetail(EmploymentDetails employeeDetail) {
		EmploymentDetails addressDetails = EmploymentDetails.builder()
				.employmentType(employeeDetail.getEmploymentType())
				.employmentStatus(employeeDetail.getEmploymentStatus())
				.natureOfWork(employeeDetail.getNatureOfWork())
				.employerName(employeeDetail.getEmployerName())
				.employerAddress(employeeDetail.getEmployerAddress())
				.industryType(employeeDetail.getIndustryType())
				.build();
		iEmployementDetailsRepo.save(addressDetails);
		return ResponseModel.builder().message("data added successfully").messageTypeId(MessageTypeConst.SUCCESS.getMessage()).statusCode(HttpStatus.OK).build();	
	}

	@Override
	public ResponseModel updateEmploymentDetail(EmploymentDetails employeeDetail, Long empId) {
		iEmployementDetailsRepo.findById(empId).ifPresentOrElse(x->{
			EmploymentDetails updateAddressModel = EmploymentDetails.builder()
					.id(empId)
					.employmentType(employeeDetail.getEmploymentType())
					.employmentStatus(employeeDetail.getEmploymentStatus())
					.natureOfWork(employeeDetail.getNatureOfWork())
					.employerName(employeeDetail.getEmployerName())
					.employerAddress(employeeDetail.getEmployerAddress())
					.industryType(employeeDetail.getIndustryType())
					.build();
			iEmployementDetailsRepo.save(updateAddressModel);	
		},()-> {throw new RecordNotFoundException("user details is not present in our db pls try another");});
		return ResponseModel.builder().message("profile data updated Successfully").statusCode(HttpStatus.OK).messageTypeId(MessageTypeConst.SUCCESS.getMessage()).build();	
	}
}
