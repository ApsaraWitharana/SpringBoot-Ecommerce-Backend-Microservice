package lk.ijse.gdse68.orderservice.service;

import lk.ijse.gdse68.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void save(OrderDTO dto);
    void delete(String id);
    void update(String id, OrderDTO dto);
    OrderDTO get(String id);
    List<OrderDTO> getAll();
}
