package lk.ijse.gdse68.customerservice.controller;

import lk.ijse.gdse68.customerservice.dto.CustomerDTO;
import lk.ijse.gdse68.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-14
 #**/

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer() {
        List<CustomerDTO> employees = customerService.getAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return ResponseEntity.status(201).body("Customer saved successfully!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) throws ClassNotFoundException {
        customerService.update(id, customerDTO);
        return ResponseEntity.ok("Customer updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.ok("Customer deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getEmployee(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.get(id);
        return ResponseEntity.ok(customerDTO);
    }
}
