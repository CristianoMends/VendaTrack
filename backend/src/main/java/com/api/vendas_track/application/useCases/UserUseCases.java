package com.api.vendas_track.application.useCases;

import com.api.vendas_track.domain.user.CreateUserDto;
import com.api.vendas_track.domain.user.LoginDto;
import com.api.vendas_track.domain.user.ViewUserDto;

public interface UserUseCases {

    void save(CreateUserDto dto);
    ViewUserDto getById(Long id);
    String authenticateUser(LoginDto loginDto);

}
