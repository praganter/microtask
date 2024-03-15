package dev.batuhanyetgin.msorder.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "\"order\"")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_date")
    private LocalDateTime orderDate;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "customer_id")
    private Long customer_id;

    @OneToMany(mappedBy = "order")
    private List<OrderBookEntity> orderBookEntityList;
}
