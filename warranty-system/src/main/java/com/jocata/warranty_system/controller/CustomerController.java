package com.jocata.warranty_system.controller;

import com.jocata.warranty_system.entity.Customers;
import com.jocata.warranty_system.form.CustomerReqForm;
import com.jocata.warranty_system.form.CustomerResForm;
import com.jocata.warranty_system.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private CustomerService service;


    //http://localhost:8080/warrantysystem/api/v1/CreateCustomer
    @PostMapping("/CreateCustomer")
    public CustomerResForm createCustomer(@RequestBody CustomerReqForm form) {
        CustomerResForm res=null;
        try{
            if(form.getName()!=null && !form.getName().isEmpty() &&
            form.getEmail()!=null && !form.getEmail().isEmpty() &&
            form.getPhone()!=null && !form.getPhone().isEmpty() &&
            form.getAddress()!=null && !form.getAddress().isEmpty())
                    res = service.createCustomer(form);
            if(res!=null){
                return res;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //http://localhost:8080/warrantysystem/api/v1/UpdateCustomer
    @PutMapping("/UpdateCustomer")
    public CustomerResForm updateCustomer(@RequestBody CustomerReqForm form) {
        CustomerResForm res=null;
        try{
            if(form.getId()!=null && !form.getId().isEmpty() &&
            form.getName()!=null && !form.getName().isEmpty() &&
            form.getEmail()!=null && !form.getEmail().isEmpty() &&
            form.getPhone()!=null && !form.getPhone().isEmpty() &&
            form.getAddress()!=null && !form.getAddress().isEmpty())
                        res=  service.updateCustomer(form);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //http://localhost:8080/warrantysystem/api/v1/GetCustomer?id=1
    @GetMapping("/GetCustomer")
    public CustomerResForm getCustomer(@RequestParam String id) {
        CustomerResForm res=null;
        try{
            if(id!=null && !id.isEmpty())
                    res = service.getCustomer(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    //http://localhost:8080/warrantysystem/api/v1/GetAllCustomer
    @GetMapping("/GetAllCustomer")
    public List<CustomerResForm> getAllCustomer() {
        List<CustomerResForm> res;
        try{
            res= service.getAllCustomer();
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    //http://localhost:8080/warrantysystem/api/v1/DeleteCustomer?id=1
    @DeleteMapping("/DeleteCustomer")
    public String deleteCustomer(@RequestParam String id) {
        String res=null;
        try{
            if(id!=null && !id.isEmpty())
                    res=service.deleteCustomer(id);
            if(res!=null){
                return res;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       return null;
    }
}