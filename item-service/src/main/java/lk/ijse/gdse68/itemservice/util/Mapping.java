package lk.ijse.gdse68.itemservice.util;

import lk.ijse.gdse68.itemservice.dto.ItemDTO;
import lk.ijse.gdse68.itemservice.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-15
 #**/

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public ItemDTO convertToDTO(ItemEntity entity) {
        return new ItemDTO(
                entity.getId(), // Map entity's 'id' to DTO's 'employeeId'
                entity.getName(),
                entity.getQty(),
                entity.getDescription(),
                entity.getPrice()
        );
    }

    public ItemEntity convertToEntity(ItemDTO dto) {
        ItemEntity entity = new ItemEntity();
        entity.setId(dto.getItemId()); // Map DTO's 'itemId' to entity's 'id'
        entity.setName(dto.getName());
        entity.setQty(dto.getQty());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        return entity;
    }

}
