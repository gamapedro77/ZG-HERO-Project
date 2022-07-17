package com.linketinder.MSCadastro.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class TokenDTO {

    private String login;

    private String access_token;

    public TokenDTO(String login, String token) {
        this.setLogin(login);
        this.setAccess_token(token);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

}
