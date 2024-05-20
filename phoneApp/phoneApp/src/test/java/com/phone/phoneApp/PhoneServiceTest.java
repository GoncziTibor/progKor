package com.phone.phoneApp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.repository.PhoneRepository;
import com.phone.phoneApp.service.PhoneService;

public class PhoneServiceTest {

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private PhoneService phoneService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSavePhone() {
        Phone phone = new Phone();
        phone.setBrand("Samsung");
        phone.setModel("Galaxy");
        phone.setPrice(500);
        phone.setOperatingSystem("Android");
        phone.setReleaseYear(2023);

        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        Phone savedPhone = phoneService.savePhone(phone);
        assertNotNull(savedPhone);
        assertEquals("Samsung", savedPhone.getBrand());
        assertEquals("Galaxy", savedPhone.getModel());
        assertEquals(500, savedPhone.getPrice());
        assertEquals("Android", savedPhone.getOperatingSystem());
        assertEquals(2023, savedPhone.getReleaseYear());
    }

    @Test
    public void testGetPhoneById() {
        Phone phone = new Phone();
        phone.setId(1);
        phone.setBrand("Samsung");
        phone.setModel("Galaxy");
        phone.setPrice(500);
        phone.setOperatingSystem("Android");
        phone.setReleaseYear(2023);

        when(phoneRepository.findById(anyInt())).thenReturn(Optional.of(phone));

        Phone foundPhone = phoneService.getPhoneId(1);
        assertNotNull(foundPhone);
        assertEquals(1, foundPhone.getId());
        assertEquals("Samsung", foundPhone.getBrand());
        assertEquals("Galaxy", foundPhone.getModel());
        assertEquals(500, foundPhone.getPrice());
        assertEquals("Android", foundPhone.getOperatingSystem());
        assertEquals(2023, foundPhone.getReleaseYear());
    }

    @Test
    public void testGetPhoneByIdNotFound() {
        when(phoneRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> phoneService.getPhoneId(999));
    }



    @Test
    public void testDeletePhone() {
        int phoneId = 1;

        phoneService.deletePhone(phoneId);

        verify(phoneRepository, times(1)).deleteById(phoneId);
    }

    @Test
    public void testUpdatePhone() {
        Phone phone = new Phone();
        phone.setId(1);
        phone.setBrand("Samsung");
        phone.setModel("Galaxy");
        phone.setPrice(500);
        phone.setOperatingSystem("Android");
        phone.setReleaseYear(2023);

        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        Phone updatedPhone = phoneService.updatePhone(phone);

        assertNotNull(updatedPhone);
        assertEquals(1, updatedPhone.getId());
        assertEquals("Samsung", updatedPhone.getBrand());
        assertEquals("Galaxy", updatedPhone.getModel());
        assertEquals(500, updatedPhone.getPrice());
        assertEquals("Android", updatedPhone.getOperatingSystem());
        assertEquals(2023, updatedPhone.getReleaseYear());
    }
}
