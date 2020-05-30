package org.cypherpage.spring_page.model;

import javax.persistence.*;

@Entity
@Table(name = "user", indexes = {
        @Index(columnList = "login,password", name = "login_password_idx")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String password;

    public User() {
    }

    public User(String name, String surname, String patronymic, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
