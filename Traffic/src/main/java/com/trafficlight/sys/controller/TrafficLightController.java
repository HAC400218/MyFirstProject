package com.trafficlight.sys.controller;

import com.trafficlight.sys.model.TrafficDirection;
import com.trafficlight.sys.service.InterSection;
import com.trafficlight.sys.service.TrafficLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("intersections/api")
public class TrafficLightController {

    @Autowired
    private TrafficLightService trafficLightService;

    @PostMapping("/{id}")
    public ResponseEntity<?> createInterSections(@PathVariable("id") String intersectionId){
        InterSection interSections=trafficLightService.TrafficLightService(intersectionId);
        return new ResponseEntity<>(interSections, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/green/{TrafficDirection}")
    public ResponseEntity<?> changeTrafficColorGreen(@PathVariable("id") String intersectionId,
                     @PathVariable("TrafficDirection") TrafficDirection direction){
        trafficLightService.changeLightColor(intersectionId,direction);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/pause")
    public ResponseEntity<?> changePause(@PathVariable("id") String intersectionId){
        trafficLightService.changePause(intersectionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/resume")
    public ResponseEntity<?> changeResume(@PathVariable("id") String intersectionId){
        trafficLightService.changeResume(intersectionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/currentstate")
    public ResponseEntity<?> getCurrentState(@PathVariable("id") String intersectionId){
        InterSection interSection=trafficLightService.getIntersections(intersectionId);
        return new ResponseEntity<>(interSection,HttpStatus.OK);
    }
}
