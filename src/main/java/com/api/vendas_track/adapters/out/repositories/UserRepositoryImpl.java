package com.api.vendas_track.adapters.out.repositories;

import com.api.vendas_track.adapters.out.entities.JpaUserEntity;
import com.api.vendas_track.domain.user.User;
import com.api.vendas_track.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }


    @Override
    public Optional<User> save(User user) {
        JpaUserEntity entity = new JpaUserEntity(user);
        JpaUserEntity saved = this.jpaUserRepository.save(entity);
        return Optional.of(new User(saved));
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.jpaUserRepository.findById(id).map(User::new);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.jpaUserRepository.findByEmail(email).map(User::new);
    }
}
