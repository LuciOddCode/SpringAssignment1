package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;



    @Override
    public void addItem(ItemDTO dto) {
        if (itemRepo.existsById(dto.getCode())) {
            throw new RuntimeException("Item Already Exist");
        }
        Item item = mapper.map(dto, Item.class);
        itemRepo.save(item);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> all = itemRepo.findAll();
        return mapper.map(all,new TypeToken<List<ItemDTO>>(){}.getType());
    }

    @Override
    public void deleteItem(String code) {
        if (!itemRepo.existsById(code)) {
            throw new RuntimeException("No Item for Delete..!");
        }
        itemRepo.deleteById(code);
    }

    @Override
    public ItemDTO findItem(String code) {
        Item item = itemRepo.findById(code).get();
        return mapper.map(item,ItemDTO.class);
    }

    @Override
    public void updateItem(ItemDTO dto) {
        if(!itemRepo.existsById(dto.getCode())){
            throw new RuntimeException("No Item for Update..!");
        }
        Item item = mapper.map(dto, Item.class);
        itemRepo.save(item);
    }
}
