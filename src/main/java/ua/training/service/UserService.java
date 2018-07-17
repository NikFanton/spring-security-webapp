package ua.training.service;

import ua.training.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
