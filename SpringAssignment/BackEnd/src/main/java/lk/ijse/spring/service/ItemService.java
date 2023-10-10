package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void addItem(ItemDTO dto);
    List<ItemDTO> getAllItems();
    void deleteItem(String code);
    ItemDTO findItem(String code);
    void updateItem(ItemDTO dto);

}
