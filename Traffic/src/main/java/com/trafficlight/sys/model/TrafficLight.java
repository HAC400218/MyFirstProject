package com.trafficlight.sys.model;

import java.time.LocalDateTime;

public class TrafficLight {

    private TrafficDirection trafficDirection;
    private TrafficLightColor trafficLightColor;
    private LocalDateTime lastupdateTime;

    public TrafficLight(TrafficDirection trafficDirection){
       this.trafficDirection=trafficDirection;
       this.trafficLightColor=TrafficLightColor.RED;
       this.lastupdateTime=LocalDateTime.now();
    }

    public void SetTrafficLightColor(TrafficLightColor newcolor){
        this.trafficLightColor=newcolor;
        this.lastupdateTime=LocalDateTime.now();
    }

    public TrafficDirection getTrafficDirection() {
        return trafficDirection;
    }

    public TrafficLightColor getTrafficLightColor() {
        return trafficLightColor;
    }

    public LocalDateTime getLastupdateTime() {
        return lastupdateTime;
    }
}
