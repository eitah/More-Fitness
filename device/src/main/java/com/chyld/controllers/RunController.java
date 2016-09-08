package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;
    private TopicExchange topicExchange;
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setUserService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange) {
        this.topicExchange = topicExchange;
    }

    @RequestMapping(value = "/{serial}/start", method = RequestMethod.POST)
    public Run startRun(@PathVariable String serial) {
//        return this.deviceService.startRun(serial);
        String topicName = topicExchange.getName();
        rabbitTemplate.convertAndSend(topicName, "fit.topic.run.start", serial);
        return null;
    }

    @RequestMapping(value = "/{serial}/stop", method = RequestMethod.POST)
    public Run stopRun(@PathVariable String serial) {
//        return this.deviceService.stopRun(serial);
        String topicName = topicExchange.getName();
        rabbitTemplate.convertAndSend(topicName, "fit.topic.run.stop", serial);
        return null;
    }
}
