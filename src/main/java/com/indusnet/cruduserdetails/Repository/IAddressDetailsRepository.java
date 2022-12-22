package com.indusnet.cruduserdetails.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.AddressDetails;

@Repository
public interface IAddressDetailsRepository extends CrudRepository<AddressDetails, Long> {}
