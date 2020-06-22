package org.cypherpage.spring_page.service;

import org.cypherpage.spring_page.model.User;
import org.cypherpage.spring_page.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepo.findByLogin(login);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

}
