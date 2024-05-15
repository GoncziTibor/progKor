package api.service;

import api.dto.Phone;
import api.entity.PhoneEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneService {

    private final Map<Long, PhoneEntity> phoneMap = new HashMap<>();
    private long nextId = 1;

    public List<PhoneEntity> getAllPhones() {
        return new ArrayList<>(phoneMap.values());
    }

    public PhoneEntity getPhoneById(Long id) {
        return phoneMap.get(id);
    }

    public PhoneEntity addPhone(Phone phone) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setId(nextId++);
        phoneEntity.setBrand(phone.getBrand());
        phoneEntity.setModel(phone.getModel());
        phoneEntity.setPrice(phone.getPrice());
        phoneEntity.setOperatingSystem(phone.getOperatingSystem());
        phoneEntity.setReleaseYear(phone.getReleaseYear());
        phoneMap.put(phoneEntity.getId(), phoneEntity);
        return phoneEntity;
    }

    public PhoneEntity updatePhone(Long id, Phone phone) {
        if (phoneMap.containsKey(id)) {
            PhoneEntity phoneEntity = phoneMap.get(id);
            phoneEntity.setBrand(phone.getBrand());
            phoneEntity.setModel(phone.getModel());
            phoneEntity.setPrice(phone.getPrice());
            phoneEntity.setOperatingSystem(phone.getOperatingSystem());
            phoneEntity.setReleaseYear(phone.getReleaseYear());
            return phoneEntity;
        } else {
            return null;
        }
    }

    public void deletePhone(Long id) {
        phoneMap.remove(id);
    }
}

