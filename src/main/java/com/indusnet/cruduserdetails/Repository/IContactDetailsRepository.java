package com.indusnet.cruduserdetails.Repository;

import org.springframework.data.repository.CrudRepository;

import com.indusnet.cruduserdetails.model.ContactDetails;

public interface IContactDetailsRepository extends CrudRepository<ContactDetails,Long>{

}
