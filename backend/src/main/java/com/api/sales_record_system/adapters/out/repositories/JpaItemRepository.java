package com.api.sales_record_system.adapters.out.repositories;

import com.api.sales_record_system.adapters.out.entities.JpaItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaItemRepository extends JpaRepository<JpaItemEntity, Long> {

    @Override
    Optional<JpaItemEntity> findById(Long uuid);
}
