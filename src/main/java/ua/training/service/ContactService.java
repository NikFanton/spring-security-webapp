package ua.training.service;

import ua.training.model.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);
    List<Contact> findAllContacts();
    Contact findById(Long id);
    void update(Contact contact);
    void deleteContact(Long id);
}
