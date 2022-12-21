package com.indusnet.cruduserdetails.service;

import java.util.List;
import com.indusnet.cruduserdetails.model.FinancialDetails;
import com.indusnet.cruduserdetails.model.common.ResponseModel;

public interface IFinancialDetailsService {
	public  List<FinancialDetails> getAllUser();
	public FinancialDetails getFinancialDetail(Long userId);
	public ResponseModel createFinancialDetail( FinancialDetails user);
	public ResponseModel updateFinancialDetail(FinancialDetails person,Long user);
	public ResponseModel deleteFinancialDetail(Long personalId);
}
