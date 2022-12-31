package com.bootcamp.pos.EzyPOS.api;

import com.bootcamp.pos.EzyPOS.dto.request.CustomerDto;
import org.springframework.web.bind.annotation.*;

public class CustomerController {

    @PostMapping("/create")
    public String save(@RequestBody CustomerDto dto){
        return dto.toString();
    }

    @GetMapping("{id}")
    public String findCustomer(@PathVariable String id){
        return id+" - customer";
    }
    @PutMapping(value ="/modify",params = {"id"})
    public String updateCustomer(@RequestBody CustomerDto dto,@RequestParam String id){
        return dto+" - "+id;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable String id){
        return id+" - Customer";
    }

    @GetMapping("/list")
    public String findAllCustomers(){
        return "all customers";
    }
}
