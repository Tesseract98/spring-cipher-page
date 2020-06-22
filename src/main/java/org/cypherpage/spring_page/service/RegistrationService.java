package org.cypherpage.spring_page.service;

import org.cypherpage.spring_page.dto.RegistrationDtoResponse;
import org.cypherpage.spring_page.model.Role;
import org.cypherpage.spring_page.model.User;
import org.cypherpage.spring_page.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepo;

    public boolean saveUser(RegistrationDtoResponse response) {
        if (userRepo.findByLogin(response.getLogin()) != null) {
            return false;
        }
        User user = response.createUser();
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
        return true;
    }
}
