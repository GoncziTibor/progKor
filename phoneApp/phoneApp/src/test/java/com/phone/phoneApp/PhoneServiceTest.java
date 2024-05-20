package com.phone.phoneApp;

import com.phone.phoneApp.dto.Phone;

import com.phone.phoneApp.repository.PhoneRepository;
import com.phone.phoneApp.service.PhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PhoneServiceTest {

    @InjectMocks
    private PhoneService phoneService;

    @Mock
    private PhoneRepository phoneRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSavePhone() {
        Phone phone = new Phone();
        phone.setBrand("Brand");
        phone.setModel("Model");

        when(phoneRepository.save(phone)).thenReturn(phone);

        Phone result = phoneService.savePhone(phone);

        assertEquals(phone, result);
        verify(phoneRepository, times(1)).save(phone);
    }

    @Test
    public void testAllPhone() {
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(new Phone());
        when(phoneRepository.findAll()).thenReturn(phoneList);

        List<Phone> result = phoneService.allPhone();

        assertEquals(phoneList, result);
        verify(phoneRepository, times(1)).findAll();
    }

    @Test
    public void testGetPhoneId() {
        Phone phone = new Phone();
        when(phoneRepository.findById(1)).thenReturn(Optional.of(phone));

        Phone result = phoneService.getPhoneId(1);

        assertEquals(phone, result);
        verify(phoneRepository, times(1)).findById(1);
    }

    @Test
    public void testGetPhoneIdNotFound() {
        when(phoneRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> {
            phoneService.getPhoneId(1);
        });
        verify(phoneRepository, times(1)).findById(1);
    }

    @Test
    public void testDeletePhone() {
        doNothing().when(phoneRepository).deleteById(1);

        phoneService.deletePhone(1);

        verify(phoneRepository, times(1)).deleteById(1);
    }

    @Test
    public void testUpdatePhone() {
        Phone phone = new Phone();
        when(phoneRepository.save(phone)).thenReturn(phone);

        Phone result = phoneService.updatePhone(phone);

        assertEquals(phone, result);
        verify(phoneRepository, times(1)).save(phone);
    }
}