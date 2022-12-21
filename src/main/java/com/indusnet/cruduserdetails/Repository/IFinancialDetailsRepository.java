package com.indusnet.cruduserdetails.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.FinancialDetails;

@Repository
public interface IFinancialDetailsRepository extends CrudRepository<FinancialDetails,Long> {

}
