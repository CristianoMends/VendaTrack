package com.api.vendas_track.adapters.out.repositories;

import com.api.vendas_track.adapters.out.entities.JpaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaItemRepository extends JpaRepository<JpaItemEntity, Long> {

    @Override
    Optional<JpaItemEntity> findById(Long uuid);
}
