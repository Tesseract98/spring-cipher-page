package server.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserAuthorizationDtoResponse {

    @Size(min = 5, message = "Минимальная длина 5 символов")
    private String login;

    @Size(min = 6, message = "")
    @Pattern(regexp = "(([a-zA-Z]*)([!-@])+([a-zA-Z]*))+", message = "неправильный пароль")
    private String password;

    public UserAuthorizationDtoResponse() {
    }

    public UserAuthorizationDtoResponse(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
