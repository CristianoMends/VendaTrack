package com.api.sales_record_system.application.useCases;

import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.domain.sale.CreateSaleDto;
import com.api.sales_record_system.domain.sale.ViewSaleDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SaleUseCases {
    void save(CreateSaleDto createSaleDto);

    void delete(Long id);

    List<ViewSaleDto> list(Long id,
                           PaymentMethod paymentMethod,
                           LocalDateTime dateStart,
                           LocalDateTime dateEnd,
                           Long itemId);

}
