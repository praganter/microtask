package dev.batuhanyetgin.msorder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "\"order_book\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "isbn")
    private Long isbn;

    @Column(name = "quantity")
    private int quantity;
}
