package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrderDTO dto);
    ItemDTO findOrder(String code);


}
