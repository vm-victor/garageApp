package com.vehiclemind.garage.web;

import com.axelor.app.AxelorModule;

import com.vehiclemind.garage.web.services.AppointmentService;
import com.vehiclemind.garage.web.services.Impl.AppointmentServiceImpl;

public class GarageModule extends AxelorModule { 

  @Override
  protected void configure() {
    bind(AppointmentService.class).to(AppointmentServiceImpl.class); 
  }
}