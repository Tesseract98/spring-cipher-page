package org.cypherpage.spring_page.dto;

import org.cypherpage.spring_page.dto.exceptions.DtoErrorCode;
import org.cypherpage.spring_page.dto.exceptions.DtoException;
import org.cypherpage.spring_page.model.User;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegistrationDtoResponse {

    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String name;

    @Size(min = 2, message = "Минимальная длина 2 символа")
    private String surname;

    @NotNull
    private String patronymic;

    @Size(min = 5, message = "Минимальная длина 5 символов")
    private String login;

    @Size(min = 6, message = "Минимальная длина 6 символов")
    @javax.validation.constraints.Pattern(regexp = "(([a-zA-Z]*)([!-@])+([a-zA-Z]*))+", message = "должен содержать хотя бы одну цифру или некоторый специальный символ")
    private String password;

    @NotNull
    private String checkPassword;

    @NotNull
    private boolean passwordsEqual;

    private Pattern pattern;
    private String digitsRegex = ".*\\d+.*";

    public RegistrationDtoResponse() {
    }

    public RegistrationDtoResponse(String name, String surname, String patronymic, String login, String password, String checkPassword) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.checkPassword = checkPassword;
        pattern = Pattern.compile("(([a-zA-Z]*)(\\d|\\W)+([a-zA-Z]*))+");
    }

    @AssertTrue(message = "Проверочный пароль не совпадает с основным")
    public boolean isPasswordsEqual() {
        return password != null && password.equals(checkPassword);
    }

    public void setPasswordsEqual(boolean passwordsEqual) {
        this.passwordsEqual = passwordsEqual;
    }

    private boolean isEmptyStr(String ...str){
        return Stream.of(str).anyMatch(String::isEmpty);
    }

    private boolean checkNameSurname(String str){
        return str.length() < 2 || str.matches(digitsRegex);
    }

    private boolean checkPatronymic(String str){
        if(!str.isEmpty()){
            return str.length() < 3 || str.matches(digitsRegex);
        }
        return false;
    }

    private boolean checkLogin(String str){
        return str.length() < 5;
    }

    private boolean checkPassword(String str){
        Matcher matcher = pattern.matcher(str);
        return str.length() < 6 || !matcher.find();
    }

    public void validate() throws DtoException {
        if(isEmptyStr(name, surname, login, password)){
            throw new DtoException(DtoErrorCode.EMPTY_FIELD);
        }
        if(checkNameSurname(name)){
            throw new DtoException(DtoErrorCode.WRONG_USER_NAME);
        }
        if(checkNameSurname(surname)){
            throw new DtoException(DtoErrorCode.WRONG_USER_SURNAME);
        }
        if(checkPatronymic(patronymic)){
            throw new DtoException(DtoErrorCode.WRONG_USER_PATRONYMIC);
        }
        if(checkLogin(login)){
            throw new DtoException(DtoErrorCode.WRONG_USER_LOGIN);
        }
        if(checkPassword(password)){
            throw new DtoException(DtoErrorCode.WRONG_USER_PASSWORD);
        }
        if(!password.equals(checkPassword)){
            throw new DtoException(DtoErrorCode.WRONG_USER_CHK_PASSWORD);
        }
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

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public User createUser(){
        return new User(name, surname, patronymic, login, password);
    }

}
