package de.awacademy.linkz.user;

import javax.validation.constraints.Size;

public class RegistrationDTO {
    @Size(min = 3, max = 50)
    private final String username;

    @Size(min = 5)
    private final String password1;
    private final String password2;

    public RegistrationDTO(String username, String password1, String password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }
}
