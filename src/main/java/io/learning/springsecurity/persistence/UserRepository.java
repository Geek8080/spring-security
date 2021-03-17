package io.learning.springsecurity.persistence;

import io.learning.springsecurity.web.model.User;

public interface UserRepository {
    Iterable<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);
}
