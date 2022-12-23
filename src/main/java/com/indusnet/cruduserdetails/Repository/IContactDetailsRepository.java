package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.ContactDetails;

@Repository
public interface IContactDetailsRepository extends CrudRepository<ContactDetails,Long>{
	Optional<ContactDetails> findByMobile(String mobile);
}
