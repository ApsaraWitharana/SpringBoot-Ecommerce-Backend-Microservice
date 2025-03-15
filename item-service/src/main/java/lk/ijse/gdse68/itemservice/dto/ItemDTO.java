package lk.ijse.gdse68.itemservice.dto;

import lk.ijse.gdse68.itemservice.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : sachini apsara
 * @date : 2024-03-15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements ItemResponse, SuperDTO {
    private String itemId;
    private String name;
    private int qty;
    private String description;
    private double price;
}
