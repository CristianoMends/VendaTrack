package com.api.vendas_track.application.useCases;

import com.api.vendas_track.domain.user.User;

public interface TokenUseCases {

    String generateToken(User user);

    String validateToken(String token);

    User getUserFromToken(String token);

    void invalidateToken(String token);

}
