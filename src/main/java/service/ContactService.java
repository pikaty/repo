package service;

import domain.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> findAll();
    public Contact findById(Long id);
    public Contact save(Contact contact);

}
