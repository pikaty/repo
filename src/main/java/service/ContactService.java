package service;

import domain.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService {
    public List<Contact> findAll();
    public Contact findById(Long id);
    public Contact save(Contact contact);
    public Page<Contact> findAllByPage(Pageable pageable);

}
