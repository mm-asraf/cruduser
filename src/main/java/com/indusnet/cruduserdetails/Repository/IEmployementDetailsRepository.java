package com.indusnet.cruduserdetails.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.EmploymentDetails;

@Repository
public interface IEmployementDetailsRepository extends CrudRepository<EmploymentDetails, Long> {

}
