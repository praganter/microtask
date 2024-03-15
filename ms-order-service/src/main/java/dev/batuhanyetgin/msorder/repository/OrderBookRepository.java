package dev.batuhanyetgin.msorder.repository;

import dev.batuhanyetgin.msorder.entity.OrderBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBookEntity, Long> {
}
