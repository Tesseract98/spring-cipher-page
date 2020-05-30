package org.cypherpage.spring_page.repo;

import org.cypherpage.spring_page.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);
}
