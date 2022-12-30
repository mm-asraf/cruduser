package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.FinancialDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IFinancialDetailsService {
	public  List<FinancialDetails> getAllFinancialUser();
	public FinancialDetails getFinancialDetail(Long finId);
	public ResponseModel createFinancialDetail( FinancialDetails financialDetail);
	public ResponseModel updateFinancialDetail(FinancialDetails financialDetail,Long finId);
	
}
