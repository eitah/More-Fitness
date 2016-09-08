package com.chyld.messaging;

import com.chyld.entities.Position;
import com.chyld.services.DeviceService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
public class RunGetterService {
    private DeviceService service;

    @Autowired
    public void setService(DeviceService service) { this.service = service;}

    @RabbitListener(queues = "fit.queue.run")
    @Transactional
    public void receive(Message msg, String serial){
        String key = msg.getMessageProperties().getReceivedRoutingKey();

        if (key.equals("fit.topic.run.start")) {
            service.startRun(serial);
        }
        else {
            service.stopRun(serial);
        }

    }
}
