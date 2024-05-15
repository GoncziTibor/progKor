package api.service;

import api.dto.Phone;
import api.entity.PhoneEntity;
import api.exception.PhoneException;
import api.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<PhoneEntity> getAllPhones() {
        return phoneRepository.findAll();
    }

    public PhoneEntity getPhoneById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneException(id));
    }

    public PhoneEntity addPhone(Phone phone) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setBrand(phone.getBrand());
        phoneEntity.setModel(phone.getModel());
        phoneEntity.setPrice(phone.getPrice());
        phoneEntity.setOperatingSystem(phone.getOperatingSystem());
        phoneEntity.setReleaseYear(phone.getReleaseYear());
        return phoneRepository.save(phoneEntity);
    }

    public PhoneEntity updatePhone(Long id, Phone phone) {
        PhoneEntity phoneEntity = phoneRepository.findById(id)
                .orElseThrow(() -> new PhoneException(id));
        phoneEntity.setBrand(phone.getBrand());
        phoneEntity.setModel(phone.getModel());
        phoneEntity.setPrice(phone.getPrice());
        phoneEntity.setOperatingSystem(phone.getOperatingSystem());
        phoneEntity.setReleaseYear(phone.getReleaseYear());
        return phoneRepository.save(phoneEntity);
    }

    public void deletePhone(Long id) {
        if (!phoneRepository.existsById(id)) {
            throw new PhoneException(id);
        }
        phoneRepository.deleteById(id);
    }
}
