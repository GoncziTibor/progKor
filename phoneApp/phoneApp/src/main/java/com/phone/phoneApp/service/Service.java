package com.phone.phoneApp.service;

import com.phone.phoneApp.dto.Phone;

import java.util.List;

public interface Service {
    public Phone savePhone(Phone phone);

    public List<Phone> allPhone();
}
