package com.api.sales_record_system;

import com.api.sales_record_system.controller.SaleController;
import com.api.sales_record_system.dto.CreateSaleDto;
import com.api.sales_record_system.dto.SaleView;
import com.api.sales_record_system.dto.SearchDto;
import com.api.sales_record_system.dto.UpdateSaleDto;
import com.api.sales_record_system.entity.Sale;
import com.api.sales_record_system.enums.PaymentMethod;
import com.api.sales_record_system.service.SaleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SaleController.class)
class SaleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaleService saleService;
    @Autowired
    private ObjectMapper objectMapper;

    private CreateSaleDto createSaleDto;
    private UpdateSaleDto updateSaleDto;
    private SaleView saleView;

    @BeforeEach
    void setUp() {
        createSaleDto = new CreateSaleDto(100.0, "Test Sale", PaymentMethod.CREDIT);
        updateSaleDto = new UpdateSaleDto("Updated Sale", 150.0, PaymentMethod.DEBIT);
        saleView = new SaleView(100.0, "Test Sale", PaymentMethod.CREDIT, LocalDateTime.now());
    }
    @Test
    void testRegisterSale() throws Exception {
        Sale sale = new Sale(100.0, "Test Sale", PaymentMethod.CREDIT, LocalDateTime.now());

        Mockito.when(saleService.saveSale(any(CreateSaleDto.class))).thenReturn(sale);

        mockMvc.perform(post("/sales")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createSaleDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description").value("Test Sale"))
                .andExpect(jsonPath("$.price").value(100.0));
    }
}
