package com.api.sales_record_system.adapters.out.repository;

import com.api.sales_record_system.domain.sale.Sale;
import com.api.sales_record_system.domain.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM sale " +
                    "WHERE description LIKE %?1% " +
                    "AND (?2 != 5 OR payment_method = ?2) " +
                    "AND (price BETWEEN ?3 AND ?4) " +
                    "AND (date BETWEEN ?5 AND ?6) " +
                    "ORDER BY date DESC"
    )

    List<Sale> findByFilters(
            String description,
            PaymentMethod paymentMethod,
            Double startPrice,
            Double endPrice,
            LocalDateTime initDate,
            LocalDateTime finalDate
    );



}
