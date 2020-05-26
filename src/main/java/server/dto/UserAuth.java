package server.dto;

public class UserAuth {

    private String login;
    private String password;

    public UserAuth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
