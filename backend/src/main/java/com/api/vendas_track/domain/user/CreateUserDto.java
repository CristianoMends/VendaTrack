package com.api.vendas_track.domain.user;

import com.api.vendas_track.domain.enums.UserAccess;

public class CreateUserDto {

    private String name;
    private String email;
    private String password;
    private UserAccess access;

    public CreateUserDto(String name, String email, String password, UserAccess access) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccess getAccess() {
        return access;
    }

    public void setAccess(UserAccess access) {
        this.access = access;
    }
}
