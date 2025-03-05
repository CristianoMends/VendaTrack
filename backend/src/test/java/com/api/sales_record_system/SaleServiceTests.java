package com.api.sales_record_system;

import com.api.sales_record_system.application.service.SaleServiceImpl;
import com.api.sales_record_system.domain.enums.PaymentMethod;
import com.api.sales_record_system.domain.item.Item;
import com.api.sales_record_system.domain.item.ItemRepository;
import com.api.sales_record_system.domain.sale.*;
import com.api.sales_record_system.infrastructure.exception.BusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleServiceTests {

	@Mock
	private SaleRepository saleRepository;

	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
	private SaleServiceImpl saleService;

	private CreateSaleDto createSaleDto;
	private Item item;
	private Sale sale;

	@BeforeEach
	void setUp() {
		item = new Item();
		item.setId(1L);

		CreateSaleItemDto saleItemDto = new CreateSaleItemDto(1L, 2);
		createSaleDto = new CreateSaleDto(List.of(saleItemDto), LocalDateTime.now(),PaymentMethod.CREDIT);

		sale = new Sale();
		sale.setId(1L);
		sale.setPaymentMethod(PaymentMethod.CREDIT);
		sale.setDate(LocalDateTime.now());
	}

	@Test
	void save_ShouldPersistSaleAndItems_WhenDataIsValid() {
		when(saleRepository.save(any(Sale.class))).thenReturn(Optional.of(sale));
		when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

		assertDoesNotThrow(() -> saleService.save(createSaleDto));

		verify(saleRepository, times(2)).save(any(Sale.class));
		verify(itemRepository, times(1)).findById(1L);
	}

	@Test
	void save_ShouldThrowException_WhenItemNotFound() {
		when(itemRepository.findById(1L)).thenReturn(Optional.empty());
		when(saleRepository.save(any(Sale.class))).thenReturn(Optional.of(sale));

		assertThrows(BusinessException.class, () -> saleService.save(createSaleDto));

		verify(itemRepository, times(1)).findById(1L);
		verify(saleRepository, times(1)).save(any(Sale.class));
	}
}
