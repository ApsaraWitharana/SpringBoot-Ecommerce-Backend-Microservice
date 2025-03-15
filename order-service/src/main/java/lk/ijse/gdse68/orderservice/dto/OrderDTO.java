package lk.ijse.gdse68.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private LocalDate orderDate;
    private double totalPrice;
    private String customerId;
    private List<OrderItemDTO> orderItems;
}
