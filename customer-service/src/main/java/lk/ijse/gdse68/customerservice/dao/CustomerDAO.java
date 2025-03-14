package lk.ijse.gdse68.customerservice.dao;

import lk.ijse.gdse68.customerservice.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/
@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
}
