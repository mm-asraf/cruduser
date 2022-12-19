package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.indusnet.cruduserdetails.model.PersonalDetails;

public interface IUserDetailsRepository extends CrudRepository<PersonalDetails, Long> {

	Optional<PersonalDetails> findByFirstName(String firstName);
	Optional<PersonalDetails> findByLastName(String lastName);
}
