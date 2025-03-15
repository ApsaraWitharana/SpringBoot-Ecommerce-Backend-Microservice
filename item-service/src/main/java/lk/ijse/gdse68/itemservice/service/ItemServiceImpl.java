package lk.ijse.gdse68.itemservice.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse68.itemservice.dao.ItemDAO;
import lk.ijse.gdse68.itemservice.dto.ItemDTO;
import lk.ijse.gdse68.itemservice.entity.ItemEntity;
import lk.ijse.gdse68.itemservice.exception.DataPersistFailedException;
import lk.ijse.gdse68.itemservice.exception.ItemNotFoundException;
import lk.ijse.gdse68.itemservice.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : sachini apsara
 * @date : 2024-03-11
 **/

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final Mapping mapping;
    private final ItemDAO itemDAO;

    @Override
    public void save(ItemDTO dto) {
        ItemEntity savedItem = Optional.ofNullable(itemDAO.save(mapping.convertToEntity(dto)))
                .orElseThrow(() -> new DataPersistFailedException("Failed to save item data!"));
    }

    @Override
    public void delete(String id) {
        if (itemDAO.existsById(id)) {
            itemDAO.deleteById(id);
        } else {
            throw new ItemNotFoundException("Item not found for deletion!");
        }
    }

    @Override
    public void update(String id, ItemDTO dto) {
        ItemEntity entity = itemDAO.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found for update!"));

        entity.setName(dto.getName());
        entity.setQty(dto.getQty());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        itemDAO.save(entity);
    }

    @Override
    public ItemDTO get(String id) {
        ItemEntity entity = itemDAO.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found!"));
        return mapping.convertToDTO(entity);
    }

    @Override
    public List<ItemDTO> getAll() {
        return itemDAO.findAll()
                .stream()
                .map(mapping::convertToDTO)
                .collect(Collectors.toList());
    }
}
