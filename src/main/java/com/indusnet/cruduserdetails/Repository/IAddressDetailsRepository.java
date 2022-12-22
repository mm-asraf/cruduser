package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.AddressDetails;
import com.indusnet.cruduserdetails.model.PersonalDetails;

@Repository
public interface IAddressDetailsRepository extends CrudRepository<AddressDetails, Long> {
	Optional<PersonalDetails> findByAadhaarNumber(String aadhaarNumber);
}
