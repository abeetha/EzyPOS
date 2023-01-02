package com.bootcamp.pos.EzyPOS.service.impl;

import com.bootcamp.pos.EzyPOS.dto.request.CustomerDto;
import com.bootcamp.pos.EzyPOS.dto.response.CustomerResponseDto;
import com.bootcamp.pos.EzyPOS.entity.Customer;
import com.bootcamp.pos.EzyPOS.repo.CustomerRepo;
import com.bootcamp.pos.EzyPOS.service.CustomerService;
import com.bootcamp.pos.EzyPOS.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private IdGenerator idGenerator;

    @Override
    public String saveCustomer(CustomerDto dto) {
        Customer c1 = new Customer(
                idGenerator.generateId(10), dto.getName(),dto.getAddress(),dto.getSalary()
        );
        customerRepo.save(c1);
        return c1.getId()+"Saved!";
    }

    @Override
    public String findCustomer(String id) {
      /*  Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if(selectedCustomer.isPresent()){
            return selectedCustomer.get().toString();
        }
        return null;*/
        return customerRepo.findById(id).orElse(null).toString();
    }

    @Override
    public String updateCustomer(CustomerDto dto, String id) {
        Customer c =customerRepo.findById(id).orElse(null);
        if (null==c) return "Not found";
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setSalary(dto.getSalary());
        customerRepo.save(c);
        return c.getName()+"was Updated!";
    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.deleteById(id);
        return id+ " was deleted!";
    }

    @Override
    public List<CustomerResponseDto> findAllCustomers() {
        List<CustomerResponseDto> dtoList = new ArrayList<>();
        List<Customer> list = customerRepo.findAll();
        for (Customer c: list
             ){
            dtoList.add(new CustomerResponseDto(
                    c.getId(),c.getName(),c.getAddress(),c.getSalary()
            ));
        }
        return dtoList;
    }
}
