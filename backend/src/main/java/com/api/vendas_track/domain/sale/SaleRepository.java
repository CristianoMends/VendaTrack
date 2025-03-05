package com.api.vendas_track.domain.sale;

import com.api.vendas_track.domain.enums.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SaleRepository {

    Optional<Sale> save(Sale sale);

    Optional<Sale> findById(Long id);

    List<Sale> list(Long id,
                    PaymentMethod paymentMethod,
                    LocalDateTime dateStart,
                    LocalDateTime dateEnd,
                    Long itemId);

    void deleteById(Long id);

}
