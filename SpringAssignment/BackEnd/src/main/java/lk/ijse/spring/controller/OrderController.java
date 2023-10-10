package lk.ijse.spring.controller;

import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    CustomerService cService;

    @Autowired
    ItemService iService;

    @PostMapping
    public ResponseUtil placeOrder(){

    }

}
