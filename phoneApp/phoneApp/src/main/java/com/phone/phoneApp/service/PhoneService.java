package com.phone.phoneApp.service;

import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements com.phone.phoneApp.service.Service {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> allPhone() {
        return phoneRepository.findAll();
    }
}
