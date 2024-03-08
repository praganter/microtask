package dev.batuhanyetgin.msorder.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "\"order\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDateTime orderDate;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "customer_id")
    private Long customer_id;

    @OneToMany(mappedBy = "order")
    private Set<OrderBookEntity> bookList;
}
