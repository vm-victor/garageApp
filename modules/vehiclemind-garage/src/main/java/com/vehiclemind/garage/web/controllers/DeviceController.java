package com.vehiclemind.garage.web.controllers;


import com.axelor.db.JpaSupport;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;


public class DeviceController extends JpaSupport {
    public void onUpdateUuid(ActionRequest request, ActionResponse response) {
        System.out.println("test");
    }
}