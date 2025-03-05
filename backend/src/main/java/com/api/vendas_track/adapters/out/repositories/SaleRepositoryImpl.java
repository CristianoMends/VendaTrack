package com.api.vendas_track.adapters.out.repositories;

import com.api.vendas_track.adapters.out.entities.JpaSaleEntity;
import com.api.vendas_track.domain.enums.PaymentMethod;
import com.api.vendas_track.domain.sale.Sale;
import com.api.vendas_track.domain.sale.SaleRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final JpaSaleRepository jpaSaleRepository;

    public SaleRepositoryImpl(JpaSaleRepository jpaSaleRepository) {
        this.jpaSaleRepository = jpaSaleRepository;
    }

    @Override
    public Optional<Sale> save(Sale sale) {
        JpaSaleEntity entity = new JpaSaleEntity(sale);
        JpaSaleEntity saved = this.jpaSaleRepository.save(entity);
        return Optional.of(new Sale(saved));
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return this.jpaSaleRepository.findById(id).map(Sale::new);
    }

    @Override
    public List<Sale> list(Long id,
                           PaymentMethod paymentMethod,
                           LocalDateTime dateStart,
                           LocalDateTime dateEnd,
                           Long itemId) {
        return this.jpaSaleRepository.list(id, paymentMethod, dateStart, dateEnd, itemId)
                .stream()
                .map(Sale::new)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        this.jpaSaleRepository.deleteById(id);
    }
}
