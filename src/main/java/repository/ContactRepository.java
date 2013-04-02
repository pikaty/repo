package repository;

import domain.Contact;
import org.springframework.data.repository.CrudRepository;

public  interface ContactRepository extends CrudRepository<Contact, Long>{
}
