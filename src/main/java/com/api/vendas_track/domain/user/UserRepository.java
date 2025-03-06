package com.api.vendas_track.domain.user;

import java.util.Optional;

public interface UserRepository {

    Optional<User> save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

}
