package ua.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.model.Contact;

public interface ContactDao extends JpaRepository<Contact, Long> {
}
