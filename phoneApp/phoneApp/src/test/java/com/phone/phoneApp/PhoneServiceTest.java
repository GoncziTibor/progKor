package com.phone.phoneApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.repository.PhoneRepository;
import com.phone.phoneApp.service.PhoneService;

public class PhoneServiceTest {

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private PhoneService phoneService;

    public PhoneServiceTest() {
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

        Mockito.when(phoneRepository.save(Mockito.any(Phone.class))).thenReturn(phone);

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

        Mockito.when(phoneRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(phone));

        Phone foundPhone = phoneService.getPhoneId(1);
        assertNotNull(foundPhone);
        assertEquals(1, foundPhone.getId());
        assertEquals("Samsung", foundPhone.getBrand());
        assertEquals("Galaxy", foundPhone.getModel());
        assertEquals(500, foundPhone.getPrice());
        assertEquals("Android", foundPhone.getOperatingSystem());
        assertEquals(2023, foundPhone.getReleaseYear());
    }
}
