package com.vehiclemind.garage.web.controllers;

import com.axelor.db.JpaSupport;
import com.axelor.meta.CallMethod;

import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.rpc.Response;

public class CustomerController extends JpaSupport {
    @CallMethod 
    public Response validate(String email) { 


    return null;
    }
}