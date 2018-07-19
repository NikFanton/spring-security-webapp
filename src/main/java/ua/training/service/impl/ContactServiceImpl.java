package ua.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.training.dao.ContactDao;
import ua.training.model.Contact;
import ua.training.service.ContactService;

import java.util.List;

@Repository
@Transactional
@Service("contactService")
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAllContacts() {
        return contactDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findById(Long id) {
        return contactDao.findOne(id);
    }

    @Override
    public void update(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactDao.delete(id);
    }
}
