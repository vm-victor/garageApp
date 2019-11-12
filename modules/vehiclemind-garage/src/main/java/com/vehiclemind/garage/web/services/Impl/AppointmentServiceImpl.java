package com.vehiclemind.garage.web.services.Impl;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.vehiclemind.garage.db.Appointments;
import com.vehiclemind.garage.web.services.AppointmentService;

import org.hibernate.Hibernate;

import com.vehiclemind.garage.db.repo.SlotsRepository;
import com.vehiclemind.garage.db.Slots;

import com.axelor.inject.Beans;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public ArrayList<Appointments> getAppointmentBySlot(Integer slotId, LocalDateTime date) {

        List<Slots> slots = Beans.get(SlotsRepository.class).findSlot(1, date).fetch();


        return null;
    }
}