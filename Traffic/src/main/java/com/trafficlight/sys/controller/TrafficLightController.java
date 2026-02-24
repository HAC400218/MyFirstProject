package com.trafficlight.sys.controller;

import com.trafficlight.sys.service.TrafficLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("intersections/api")
public class TrafficLightController {

    @Autowired
    private TrafficLightService trafficLightService;
}
