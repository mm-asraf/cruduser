package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.EmploymentDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IEmploymentDetailsService {
	public  List<EmploymentDetails> getEmploymentDetail();
	public EmploymentDetails getEmploymentDetail(Long userId);
	public ResponseModel createEmploymentDetail( EmploymentDetails user);
	public ResponseModel updateEmploymentDetail(EmploymentDetails person,Long user);
	public ResponseModel deleteEmploymentDetail(Long personalId);
}
