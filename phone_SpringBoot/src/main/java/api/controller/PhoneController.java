package api.controller;

import api.dto.Phone;
import api.entity.PhoneEntity;

import api.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public List<PhoneEntity> getAllPhones() {
        return phoneService.getAllPhones();
    }

    @GetMapping("/{id}")
    public PhoneEntity getPhoneById(@PathVariable Long id) {
        return phoneService.getPhoneById(id);
    }

    @PostMapping("/add")
    public PhoneEntity addPhone(@RequestBody Phone phone) {
        return phoneService.addPhone(phone);
    }

    @PutMapping("/{id}")
    public PhoneEntity updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        return phoneService.updatePhone(id, phone);
    }

    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
    }
}
