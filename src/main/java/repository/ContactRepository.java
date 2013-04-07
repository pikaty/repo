package repository;

import domain.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public  interface ContactRepository extends PagingAndSortingRepository<Contact, Long>{
}
