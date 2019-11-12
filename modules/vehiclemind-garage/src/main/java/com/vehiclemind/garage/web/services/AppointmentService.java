package com.vehiclemind.garage.web.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.vehiclemind.garage.db.Appointments;

public interface AppointmentService {

 ArrayList<Appointments> getAppointmentBySlot(Integer slotId, LocalDateTime date);

}