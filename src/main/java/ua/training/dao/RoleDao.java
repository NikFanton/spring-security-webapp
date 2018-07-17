package ua.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.training.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
