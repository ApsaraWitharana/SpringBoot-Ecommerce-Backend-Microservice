package lk.ijse.gdse68.customerservice.exception;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
