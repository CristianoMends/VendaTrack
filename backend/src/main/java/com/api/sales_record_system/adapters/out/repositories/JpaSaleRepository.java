package com.api.sales_record_system.adapters.out.repositories;

import com.api.sales_record_system.adapters.out.entities.JpaSaleEntity;
import com.api.sales_record_system.domain.sale.Sale;
import com.api.sales_record_system.domain.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface JpaSaleRepository extends JpaRepository<JpaSaleEntity, Long> {

    @Query("""
            select j from JpaSaleEntity j 
            inner join j.items items
            where (:id is null or j.id = :id) 
            and (:paymentMethod is null or j.paymentMethod = :paymentMethod) 
            and ((CAST(:dateStart as TIMESTAMP) is null or CAST(:dateEnd as TIMESTAMP) is null) or j.date between :dateStart and :dateEnd) 
            and (:itemId is null or items.item.id = :itemId)
            """)
    List<JpaSaleEntity> list(
            @Param("id") Long id,
            @Param("paymentMethod") PaymentMethod paymentMethod,
            @Param("dateStart") LocalDateTime dateStart,
            @Param("dateEnd") LocalDateTime dateEnd,
            @Param("itemId") Long itemId);


}
