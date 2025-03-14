package lk.ijse.gdse68.customerservice.util;

import lk.ijse.gdse68.customerservice.dto.CustomerDTO;
import lk.ijse.gdse68.customerservice.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO convertToDTO(CustomerEntity entity) {
        return new CustomerDTO(
                entity.getId(), // Map entity's 'id' to DTO's 'employeeId'
                entity.getName(),
                entity.getAddress(),
                entity.getEmail()
        );
    }

    public CustomerEntity convertToEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getEmployeeId()); // Map DTO's 'employeeId' to entity's 'id'
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        return entity;
    }

}
