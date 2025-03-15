package lk.ijse.gdse68.orderservice.dao;

import lk.ijse.gdse68.orderservice.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDAO extends JpaRepository<OrderItemEntity, Long> {
}
