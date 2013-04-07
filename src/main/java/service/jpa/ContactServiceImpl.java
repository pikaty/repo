package service.jpa;

import com.google.common.collect.Lists;
import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ContactRepository;
import service.ContactService;

import java.util.List;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactReposiory;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return Lists.newArrayList(contactReposiory.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Contact findById(Long id) {
        return contactReposiory.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactReposiory.save(contact);
    }

    @Transactional
    @Override
    public Page<Contact> findAllByPage(Pageable pageable) {
        return contactReposiory.findAll(pageable);
    }
}
