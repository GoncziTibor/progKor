package com.phone.phoneApp.service;

import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Phone getPhoneId(Integer id){
        Optional<Phone> phones = phoneRepository.findById(id);
        if(phones.isPresent()){
            return phones.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
