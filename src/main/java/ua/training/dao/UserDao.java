package ua.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
