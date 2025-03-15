package lk.ijse.gdse68.customerservice.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.customerservice.dao.CustomerDAO;
import lk.ijse.gdse68.customerservice.dto.CustomerDTO;
import lk.ijse.gdse68.customerservice.entity.CustomerEntity;
import lk.ijse.gdse68.customerservice.exception.CustomerNotFoundException;
import lk.ijse.gdse68.customerservice.exception.DataPersistFailedException;
import lk.ijse.gdse68.customerservice.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final Mapping mapping;
    private final CustomerDAO customerDAO;

    @Override
    public void save(CustomerDTO dto) {
        CustomerEntity saveCustomer = Optional.ofNullable(customerDAO.save(mapping.convertToEntity(dto)))
                .orElseThrow(() -> new DataPersistFailedException("Failed to save Customer data!"));
    }

    @Override
    public void delete(String id) {
        if (customerDAO.existsById(id)) {
            customerDAO.deleteById(id);
        } else {
            throw new CustomerNotFoundException("Customer not found for deletion!");
        }
    }

    @Override
    public void update(String id, CustomerDTO dto) {
        CustomerEntity entity = customerDAO.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found for update!"));

        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        customerDAO.save(entity);
    }

    @Override
    public CustomerDTO get(String id) {
        CustomerEntity entity = customerDAO.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return mapping.convertToDTO(entity);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerDAO.findAll()
                .stream()
                .map(mapping::convertToDTO)
                .collect(Collectors.toList());
    }
}
