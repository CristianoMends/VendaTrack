package com.api.vendas_track.application.service;

import com.api.vendas_track.application.useCases.TokenUseCases;
import com.api.vendas_track.application.useCases.UserUseCases;
import com.api.vendas_track.domain.user.*;
import com.api.vendas_track.infrastructure.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserUseCases {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenUseCases tokenUseCases;

    @Override
    public void save(CreateUserDto dto) {
        User user = new User();
        user.setAccess(dto.getAccess());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public ViewUserDto getById(Long id) {
        return this.userRepository.findById(id)
                .map(ViewUserDto::new)
                .orElseThrow(() -> new BusinessException("User not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public String authenticateUser(LoginDto loginDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var user = (User) authentication.getPrincipal();
        return tokenUseCases.generateToken(user);
    }

}
