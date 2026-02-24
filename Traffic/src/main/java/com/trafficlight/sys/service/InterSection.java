package com.trafficlight.sys.service;

import com.trafficlight.sys.model.TrafficDirection;
import com.trafficlight.sys.model.TrafficLight;
import com.trafficlight.sys.model.TrafficLightColor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InterSection {

    private final String id;
    private final Map<TrafficDirection, TrafficLight> lights=new ConcurrentHashMap<>();

    private volatile boolean paused=false;

    public InterSection(String id){
      this.id=id;
      for(TrafficDirection trafficDirection:TrafficDirection.values()){
          lights.put(trafficDirection,new TrafficLight(trafficDirection)) ;
      }
    }

    public synchronized void SetGreen(TrafficDirection trafficDirection){
      if(paused){
          throw new IllegalStateException("InterSection is paused");
      }
      validateConflictDirection(trafficDirection);
        lights.values().forEach(trafficLight -> trafficLight.SetTrafficLightColor(TrafficLightColor.RED));
        lights.get(trafficDirection).SetTrafficLightColor(TrafficLightColor.GREEN);

    }
    private void validateConflictDirection(TrafficDirection trafficDirection){

        if(trafficDirection==TrafficDirection.EAST || trafficDirection==TrafficDirection.WEST){
          if(isGreen(TrafficDirection.NORTH) || isGreen(TrafficDirection.SOUTH)){
           throw new IllegalStateException("Conflict is detected");
          }
        }
        if(trafficDirection==TrafficDirection.NORTH || trafficDirection==TrafficDirection.SOUTH){
            if(isGreen(TrafficDirection.EAST) || isGreen(TrafficDirection.WEST)){
                throw new IllegalStateException("Conflict is detected");
            }
        }

    }
    private  boolean isGreen(TrafficDirection trafficDirection){
     if(lights.get(trafficDirection).getTrafficLightColor()==TrafficLightColor.GREEN){
         return true;
     }
     else{
         return false;
     }
    }

    public String getId() {
        return id;
    }

    public Map<TrafficDirection, TrafficLight> getLights() {
        return lights;
    }

    public void pause(){
        paused=true;
    }
    public void resume(){
        paused=false;
    }
}
