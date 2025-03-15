package lk.ijse.gdse68.orderservice.controller;

import lk.ijse.gdse68.orderservice.dto.OrderDTO;
import lk.ijse.gdse68.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return ResponseEntity.status(201).body("Order saved successfully!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable String id, @RequestBody OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
        return ResponseEntity.ok("Order updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id) {
        orderService.delete(id);
        return ResponseEntity.ok("Order deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.get(id));
    }
}
