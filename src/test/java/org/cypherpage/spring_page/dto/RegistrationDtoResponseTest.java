package org.cypherpage.spring_page.dto;

import org.cypherpage.spring_page.dto.exceptions.DtoErrorCode;
import org.cypherpage.spring_page.dto.exceptions.DtoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationDtoResponseTest {

    private String name = "Gordon";
    private String surname = "Ramzy";
    private String patronymic = "Some";
    private String login = "GorRamz";
    private String password = "admin123";
    private String checkPassword = "admin123";

    @Test
    void validate() {
        RegistrationDtoResponse response = new RegistrationDtoResponse(name, surname, patronymic, login, password, checkPassword);
        try{
            response.validate();
        } catch (DtoException exc) {
            fail();
        }

        response = new RegistrationDtoResponse(name, surname, "", login, password, checkPassword);
        try{
            response.validate();
        } catch (DtoException exc) {
            fail();
        }

        response = new RegistrationDtoResponse("", surname, "", login, password, checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.EMPTY_FIELD, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse("na1me", surname, "", login, password, checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_NAME, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse(name, "23surn2ame", "", login, password, checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_SURNAME, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse(name, surname, "olg3", login, password, checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_PATRONYMIC, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse(name, surname, "", "logi", password, checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_LOGIN, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse(name, surname, "", login, "password", checkPassword);
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_PASSWORD, exc.getDtoErrorCode());
        }

        response = new RegistrationDtoResponse(name, surname, "", login, password, "checkPassword");
        try{
            response.validate();
            fail();
        } catch (DtoException exc) {
            assertEquals(DtoErrorCode.WRONG_USER_CHK_PASSWORD, exc.getDtoErrorCode());
        }
    }

    @Test
    void testAllGetters() {
        RegistrationDtoResponse response = new RegistrationDtoResponse(name, surname, patronymic, login, password, checkPassword);
        assertAll(
                () -> assertEquals(name, response.getName()),
                () -> assertEquals(surname, response.getSurname()),
                () -> assertEquals(patronymic, response.getPatronymic()),
                () -> assertEquals(login, response.getLogin()),
                () -> assertEquals(password, response.getPassword()),
                () -> assertEquals(checkPassword, response.getCheckPassword())
        );
    }

}