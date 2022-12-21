package com.indusnet.cruduserdetails.Repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.cruduserdetails.model.PersonalDetails;

/**
 * this class contains inbuilt different methods for crud operation
 */
@Repository
public interface IPersonalDetailsRepository extends CrudRepository<PersonalDetails, Long> {
	Optional<PersonalDetails> findByFirstName(String firstName);
	Optional<PersonalDetails> findByLastName(String lastName);
}
