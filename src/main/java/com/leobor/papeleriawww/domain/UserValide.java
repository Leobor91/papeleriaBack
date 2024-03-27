package com.leobor.papeleriawww.domain;

import lombok.Data;

@Data
public class UserValide {

    private String username;
    private String password;

    public UserValide() {

    }

    public UserValide(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
