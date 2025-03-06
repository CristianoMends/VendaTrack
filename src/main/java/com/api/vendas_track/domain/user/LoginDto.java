package com.api.vendas_track.domain.user;

public record LoginDto(String email, String password) {

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }
}
