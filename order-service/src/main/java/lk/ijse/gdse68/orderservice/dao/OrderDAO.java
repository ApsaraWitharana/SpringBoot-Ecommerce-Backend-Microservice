package lk.ijse.gdse68.orderservice.dao;

import lk.ijse.gdse68.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<OrderEntity, String> {
}
