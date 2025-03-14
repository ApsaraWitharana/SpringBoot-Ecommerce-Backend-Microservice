package lk.ijse.gdse68.customerservice.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerErrorResponse implements CustomerResponse {

    private int errorCode;
    private String errorMassage;

}
