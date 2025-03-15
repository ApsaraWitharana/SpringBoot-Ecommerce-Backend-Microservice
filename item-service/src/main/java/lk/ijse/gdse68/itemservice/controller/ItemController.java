package lk.ijse.gdse68.itemservice.controller;

import lk.ijse.gdse68.itemservice.dto.ItemDTO;
import lk.ijse.gdse68.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 #* @author : sachini apsara
 #* @date : 2024-03-11
 #**/

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        List<ItemDTO> itemDTOS= itemService.getAll();
        return ResponseEntity.ok(itemDTOS);
    }

    @PostMapping
    public ResponseEntity<String> saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.save(itemDTO);
        return ResponseEntity.status(201).body("Item saved successfully!");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable String id, @RequestBody ItemDTO itemDTO) throws ClassNotFoundException {
        itemService.update(id, itemDTO);
        return ResponseEntity.ok("Item updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable String id) {
        itemService.delete(id);
        return ResponseEntity.ok("Item deleted successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable String id) {
        ItemDTO itemDTO = itemService.get(id);
        return ResponseEntity.ok(itemDTO);
    }
}
