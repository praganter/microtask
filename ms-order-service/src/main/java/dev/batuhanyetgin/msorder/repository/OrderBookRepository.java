package dev.batuhanyetgin.msorder.repository;

import dev.batuhanyetgin.msorder.entity.OrderBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBookEntity, Long> {
}
