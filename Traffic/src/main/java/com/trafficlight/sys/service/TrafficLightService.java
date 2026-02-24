package com.trafficlight.sys.service;

import com.trafficlight.sys.model.TrafficDirection;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TrafficLightService {

    private final Map<String,InterSection> intersections=new ConcurrentHashMap<>();

    public InterSection TrafficLightService(String id){
      InterSection interSection= new InterSection(id);
      intersections.put(id,interSection);
      return interSection;
    }
    public void changeLightColor(String id, TrafficDirection trafficDirection){
        intersections.get(id).SetGreen(trafficDirection);
    }

    public void changePause(String id){
      intersections.get(id).pause();
    }

    public void changeResume(String id){
        intersections.get(id).resume();
    }

    public InterSection getIntersections(String id) {
        return intersections.get(id);
    }
}
