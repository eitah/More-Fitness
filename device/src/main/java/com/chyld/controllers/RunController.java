package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;

    @Autowired
    public void setUserService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/{serial}/start", method = RequestMethod.POST)
    public Run startRun(@PathVariable String serial) {
        return this.deviceService.startRun(serial);
    }

    @RequestMapping(value = "/{serial}/stop", method = RequestMethod.POST)
    public Run stopRun(@PathVariable String serial) {
        return this.deviceService.stopRun(serial);
    }
}
