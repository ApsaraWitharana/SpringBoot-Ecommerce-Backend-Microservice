package lk.ijse.gdse68.orderservice.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.orderservice.dao.OrderDAO;
import lk.ijse.gdse68.orderservice.dao.OrderItemDAO;
import lk.ijse.gdse68.orderservice.dto.OrderDTO;
import lk.ijse.gdse68.orderservice.entity.OrderEntity;
import lk.ijse.gdse68.orderservice.entity.OrderItemEntity;
import lk.ijse.gdse68.orderservice.exception.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;
    private final OrderItemDAO orderItemDAO;

    @Override
    public void save(OrderDTO dto) {
        OrderEntity order = new OrderEntity();
        order.setId(dto.getId());
        order.setOrderDate(dto.getOrderDate());
        order.setTotalPrice(dto.getTotalPrice());

        List<OrderItemEntity> orderItems = dto.getOrderItems().stream().map(itemDTO -> {
            OrderItemEntity orderItem = new OrderItemEntity();
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(itemDTO.getPrice());
            orderItem.setOrder(order);
            return orderItem;
        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);
        orderDAO.save(order);
    }

    @Override
    public void delete(String id) {
        if (orderDAO.existsById(id)) {
            orderDAO.deleteById(id);
        } else {
            throw new OrderNotFoundException("Order not found for deletion!");
        }
    }

    @Override
    public void update(String id, OrderDTO dto) {
        OrderEntity order = orderDAO.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found for update!"));

        order.setOrderDate(dto.getOrderDate());
        order.setTotalPrice(dto.getTotalPrice());

        orderDAO.save(order);
    }

    @Override
    public OrderDTO get(String id) {
        OrderEntity order = orderDAO.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found!"));

        return new OrderDTO(order.getId(), order.getOrderDate(), order.getTotalPrice(), order.getCustomerId(), null);
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderDAO.findAll().stream().map(order -> new OrderDTO(order.getId(), order.getOrderDate(), order.getTotalPrice(), order.getCustomerId(), null)).collect(Collectors.toList());
    }
}
