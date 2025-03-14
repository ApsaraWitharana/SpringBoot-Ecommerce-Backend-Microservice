package lk.ijse.gdse68.customerservice.service;
import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-11
 #**/

public interface CRUDUtil <T>{
    void save(T dto);
    void delete(String id);
    void update(String id, T dto) throws ClassNotFoundException;
    T get(String id);
    List<T> getAll();
}
