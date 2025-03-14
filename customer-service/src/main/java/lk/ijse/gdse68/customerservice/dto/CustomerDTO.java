package lk.ijse.gdse68.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements  SuperDTO {
    private String employeeId;
    private String name;
    private String address;
    private String email;
}