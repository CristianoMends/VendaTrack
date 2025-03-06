package com.api.vendas_track.domain.user;

import com.api.vendas_track.adapters.out.entities.JpaUserEntity;
import com.api.vendas_track.domain.enums.UserAccess;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserAccess access;

    public User(Long id, String name, String email, String password, UserAccess access) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.access = access;
    }

    public User(JpaUserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.access = user.getAccess();
    }

    public User() {

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

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccess getAccess() {
        return access;
    }

    public void setAccess(UserAccess access) {
        this.access = access;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (this.access != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.access.name()));
        }
        return authorities;
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}