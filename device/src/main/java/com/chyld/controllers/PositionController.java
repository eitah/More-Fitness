package com.chyld.controllers;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private DeviceService service;

    @Autowired
    public void setService(DeviceService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{serial}", method = RequestMethod.POST)
    public Position addPosition(@PathVariable String serial, @RequestBody Position position) {
        return service.addPosition(serial, position);
    }
}
