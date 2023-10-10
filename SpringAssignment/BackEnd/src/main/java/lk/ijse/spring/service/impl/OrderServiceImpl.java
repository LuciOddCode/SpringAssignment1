package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderDetailsRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
     OrderDetailsRepo detailsRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ModelMapper mapper;



    @Override
    public void purchaseOrder(OrderDTO dto) {
       if (!orderRepo.existsById(dto.getOid())){
           Orders mapOrder = mapper.map(dto,Orders.class);
           orderRepo.save(mapOrder);

           List<OrderDetailDTO> orderDetails= dto.getOrderDetails();

           for (int i =0;i>orderDetails.size();i++){
                OrderDetails mapDetails = mapper.map(orderDetails.get(i),OrderDetails.class);
                detailsRepo.save(mapDetails);

               Item item = itemRepo.findById(orderDetails.get(i).getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand()-orderDetails.get(i).getQty());

           }
       }


    }

    @Override
    public ItemDTO findOrder(String code) {
        return null;
    }
}
