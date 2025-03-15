package lk.ijse.gdse68.itemservice.dao;

import lk.ijse.gdse68.itemservice.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-15
 #**/
@Repository
public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
