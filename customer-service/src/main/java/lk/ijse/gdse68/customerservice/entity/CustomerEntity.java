package lk.ijse.gdse68.customerservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private String id; // Should map to DTO's employeeId
    private String name;
    private String address;
    private String email;

}
