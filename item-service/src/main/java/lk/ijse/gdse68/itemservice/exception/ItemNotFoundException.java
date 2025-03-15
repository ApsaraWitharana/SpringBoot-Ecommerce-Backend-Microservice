package lk.ijse.gdse68.itemservice.exception;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-15
 #**/

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
