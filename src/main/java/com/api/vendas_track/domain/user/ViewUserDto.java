package com.api.vendas_track.domain.user;

import com.api.vendas_track.domain.enums.UserAccess;

public class ViewUserDto {
    private Long id;
    private String name;
    private String email;
    private UserAccess access;

    public ViewUserDto(Long id, String name, String email, UserAccess access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.access = access;
    }

    public ViewUserDto(User user){
        this.id = user.getId();
        this.access = user.getAccess();
        this.name = user.getName();
        this.email = user.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAccess getAccess() {
        return access;
    }

    public void setAccess(UserAccess access) {
        this.access = access;
    }
}
