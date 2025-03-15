package lk.ijse.gdse68.orderservice.entity;

import jakarta.persistence.*;
import lk.ijse.gdse68.itemservice.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    private String id;

    private int quantity;
    private double price;

    @Column(name = "item_id")
    private String itemId; // Store only the item ID

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}

