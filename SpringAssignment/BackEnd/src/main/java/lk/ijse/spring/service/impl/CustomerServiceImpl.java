package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())) {
            throw new RuntimeException("Customer Already Exist");
        }
        Customer mapped=modelMapper.map(dto,Customer.class);
        customerRepo.save(mapped);
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("No Customer for Delete..!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> allCus=customerRepo.findAll();

        return modelMapper.map(allCus,new TypeToken<List<CustomerDTO>>(){
        }.getType());
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new RuntimeException("No Customer for Delete..!");
        }

        Customer cus = customerRepo.findById(id).get();

        return modelMapper.map(cus,CustomerDTO.class);
    }

    @Override
    public void updateCustomer(CustomerDTO c) {
        if(!customerRepo.existsById(c.getId())){
            throw new RuntimeException("No Customer for Update..!");
        }

        Customer cus = modelMapper.map(c, Customer.class);

        customerRepo.save(cus);
    }
}
