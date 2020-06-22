package org.cypherpage.spring_page.repo;

import org.cypherpage.spring_page.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    List<User> findAll();

}
