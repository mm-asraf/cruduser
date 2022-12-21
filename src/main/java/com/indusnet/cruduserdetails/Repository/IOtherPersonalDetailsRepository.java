package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.indusnet.cruduserdetails.model.OtherPersonalDetails;

@Repository
public interface IOtherPersonalDetailsRepository extends CrudRepository<OtherPersonalDetails, Long> {
	Optional<OtherPersonalDetails> findByIncomeProofNumber(String incomeProofNumber);
	
}
