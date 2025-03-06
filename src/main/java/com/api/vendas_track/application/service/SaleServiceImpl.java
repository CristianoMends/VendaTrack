package com.api.vendas_track.application.service;

import com.api.vendas_track.domain.enums.PaymentMethod;
import com.api.vendas_track.domain.item.ItemRepository;
import com.api.vendas_track.domain.sale.*;
import com.api.vendas_track.domain.saleItem.SaleItem;
import com.api.vendas_track.infrastructure.exception.BusinessException;
import com.api.vendas_track.application.useCases.SaleUseCases;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleUseCases {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional
    public void save(CreateSaleDto createSaleDto) {
        Sale sale = new Sale();
        sale.setPaymentMethod(createSaleDto.getPaymentMethod());
        sale.setDate(getZonedDateTimeNow());
        sale = saleRepository.save(sale).orElseThrow();
        sale.setItems(getItems(createSaleDto.getItens(), sale));
        saleRepository.save(sale);
    }


    @Override
    public void delete(Long id) {
        if (saleRepository.findById(id).isEmpty()) {
            throw new BusinessException("Sale Not Found");
        }
        saleRepository.deleteById(id);
    }

    @Override
    public List<ViewSaleDto> list(Long id,
                                  PaymentMethod paymentMethod,
                                  LocalDateTime dateStart,
                                  LocalDateTime dateEnd,
                                  Long itemId) {
        return saleRepository.list(id,
                paymentMethod,
                dateStart,
                dateEnd,
                itemId).stream().map(this::toView).toList();
    }


    private List<SaleItem> getItems(List<CreateSaleItemDto> itemDtos, Sale sale) {
        List<SaleItem> items = new ArrayList<>();

        itemDtos.forEach(i -> {
            var item = this.itemRepository.findById(i.getItemId())
                    .orElseThrow(() -> new BusinessException("Item not found", HttpStatus.NOT_FOUND));

            items.add(new SaleItem(item, sale, i.getQuantity()));
        });
        return items;
    }


    private LocalDateTime getZonedDateTimeNow() {
        ZoneId saoPauloZone = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime saoPauloDateTime = ZonedDateTime.now(saoPauloZone);
        return saoPauloDateTime.toLocalDateTime();
    }

    private ViewSaleDto toView(Sale sale) {
        return new ViewSaleDto(
                sale.getId(),
                sale.getItems(),
                sale.getPaymentMethod(),
                sale.getDate()
        );
    }
}
