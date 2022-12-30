package com.indusnet.cruduserdetails.service;

import java.util.List;

import com.indusnet.cruduserdetails.model.EmploymentDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IEmploymentDetailsService {
	public  List<EmploymentDetails> getEmploymentDetail();
	public EmploymentDetails getEmploymentDetail(Long empId);
	public ResponseModel createEmploymentDetail( EmploymentDetails employeeDetail);
	public ResponseModel updateEmploymentDetail(EmploymentDetails employeeDetail,Long empId);
}
