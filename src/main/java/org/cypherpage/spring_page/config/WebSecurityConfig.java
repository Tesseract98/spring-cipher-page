package org.cypherpage.spring_page.config;

import org.cypherpage.spring_page.model.Role;
import org.cypherpage.spring_page.model.User;
import org.cypherpage.spring_page.repo.UserRepository;
import org.cypherpage.spring_page.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.LinkedHashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/register", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        createAdmin();
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

//     TODO: delete this code (try to make migration in mysql)
    private void createAdmin() {
        if (userRepo.findByLogin("admin") == null) {
            User user = new User("", "", "", "admin", "admin");
            user.setActive(true);

            Set<Role> roles = new LinkedHashSet<>();
            roles.add(Role.USER);
            roles.add(Role.ADMIN);
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepo.save(user);
        }
    }

}
