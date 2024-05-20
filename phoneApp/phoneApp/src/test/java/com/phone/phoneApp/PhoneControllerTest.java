package com.phone.phoneApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phone.phoneApp.controller.PhoneController;
import com.phone.phoneApp.dto.Phone;
import com.phone.phoneApp.service.PhoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PhoneControllerTest {

    @Mock
    private PhoneService phoneService;

    @InjectMocks
    private PhoneController phoneController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(phoneController).build();
    }

    @Test
    public void testGetPhones() throws Exception {
        when(phoneService.allPhone()).thenReturn(Arrays.asList(new Phone()));

        mockMvc.perform(get("/phones/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(phoneService, times(1)).allPhone();
    }

    @Test
    public void testGetPhone() throws Exception {
        Phone phone = new Phone();
        phone.setId(1);
        when(phoneService.getPhoneId(1)).thenReturn(phone);

        mockMvc.perform(get("/phones/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));

        verify(phoneService, times(1)).getPhoneId(1);
    }

    @Test
    public void testAddPhone() throws Exception {
        Phone phone = new Phone();
        phone.setId(1);
        phone.setBrand("Brand");
        when(phoneService.savePhone(any(Phone.class))).thenReturn(phone);

        mockMvc.perform(post("/phones/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(phone)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.brand").value("Brand"));

        verify(phoneService, times(1)).savePhone(any(Phone.class));
    }

    @Test
    public void testDeletePhone() throws Exception {
        doNothing().when(phoneService).deletePhone(1);

        mockMvc.perform(delete("/phones/del/1"))
                .andExpect(status().isOk());

        verify(phoneService, times(1)).deletePhone(1);
    }

    @Test
    public void testUpdatePhone() throws Exception {
        Phone phone = new Phone();
        phone.setId(1);
        phone.setBrand("Brand");
        when(phoneService.updatePhone(any(Phone.class))).thenReturn(phone);

        mockMvc.perform(put("/phones/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(phone)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.brand").value("Brand"));

        verify(phoneService, times(1)).updatePhone(any(Phone.class));
    }
}

