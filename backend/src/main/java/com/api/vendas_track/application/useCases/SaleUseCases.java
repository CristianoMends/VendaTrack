package com.api.vendas_track.application.useCases;

import com.api.vendas_track.domain.enums.PaymentMethod;
import com.api.vendas_track.domain.sale.CreateSaleDto;
import com.api.vendas_track.domain.sale.ViewSaleDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleUseCases {
    void save(CreateSaleDto createSaleDto);

    void delete(Long id);

    List<ViewSaleDto> list(Long id,
                           PaymentMethod paymentMethod,
                           LocalDateTime dateStart,
                           LocalDateTime dateEnd,
                           Long itemId);

}
