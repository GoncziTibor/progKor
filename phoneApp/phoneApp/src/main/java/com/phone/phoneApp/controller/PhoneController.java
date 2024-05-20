package com.phone.phoneApp.controller;

import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/add")
    public Phone phoneAdd(@RequestBody Phone phone){
        return phoneService.savePhone(phone);
    }

    @GetMapping("/getAll")
    public List<Phone> getPhones(){
        return phoneService.allPhone();
    }

    @GetMapping("/get/{id}")
    public Phone getPhone(@PathVariable Integer id){
        return phoneService.getPhoneId(id);
    }

    @DeleteMapping("/del/{id}")
    public void deletePhone(@PathVariable Integer id){
        phoneService.deletePhone(id);
    }

    @PutMapping("/update")
    public Phone updatePhone(@RequestBody Phone phone){
        return phoneService.updatePhone(phone);
    }

}
