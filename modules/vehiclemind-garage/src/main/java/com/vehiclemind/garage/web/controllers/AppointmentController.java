package com.vehiclemind.garage.web.controllers;

import javax.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.axelor.db.JpaSupport;
import com.axelor.meta.CallMethod;

import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Response;

import com.vehiclemind.garage.web.services.AppointmentService;

public class AppointmentController extends JpaSupport {

    @Inject AppointmentService appointmentService;

    @CallMethod 
    public Response validate(String slot, LocalDateTime date) { 

    System.out.println("Appointment Controller");
    Response response = new ActionResponse();

    appointmentService.getAppointmentBySlot(1, date);

    // response.addError("slot", "Slot already use at this time");


    return response;
    }
}