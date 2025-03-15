package lk.ijse.gdse68.orderservice.entity;

import jakarta.persistence.*;
import lk.ijse.gdse68.customerservice.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private String id;

    private LocalDate orderDate;
    private double totalPrice;
    @Column(name = "customer_id")
    private String customerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems;
}
