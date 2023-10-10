package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService service;


    @PostMapping
    public ResponseUtil placeOrder(@RequestBody OrderDTO dto){
       service.purchaseOrder(dto);
        return new ResponseUtil("Ok","Successfully Purchased",dto);
    }


}
