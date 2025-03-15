package lk.ijse.gdse68.itemservice.service;
import lk.ijse.gdse68.itemservice.dto.ItemDTO;

import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-11
 #**/

public interface CRUDUtil <T>{
    void save(T dto);
    void delete(String id);
    void update(String id, T dto) throws ClassNotFoundException;
    ItemDTO get(String id);
    List<ItemDTO> getAll();
}
