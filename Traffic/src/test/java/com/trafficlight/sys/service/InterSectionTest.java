package com.trafficlight.sys.service;

import com.trafficlight.sys.model.TrafficDirection;
import com.trafficlight.sys.model.TrafficLightColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InterSectionTest {

    private InterSection interSection;

    @BeforeEach
    void setup(){
        interSection=new InterSection("T1");
    }

    @Test
    void TestSetGreenForNorth(){
        interSection.SetGreen(TrafficDirection.NORTH);
        assertEquals(TrafficLightColor.GREEN,
                interSection
                        .getLights()
                        .get(TrafficDirection.NORTH)
                        .getTrafficLightColor()
        );
    }

    @Test
    void TestThrowExceptionWhenConflictOccur(){
        interSection.SetGreen(TrafficDirection.NORTH);
        assertThrows(IllegalStateException.class,
                ()->interSection.SetGreen(TrafficDirection.EAST)
        );
    }

    @Test
    void TestPauseInterSection(){
        interSection.pause();
        assertTrue(interSection.isPaused());
        assertThrows(IllegalStateException.class,
                ()->interSection.SetGreen(TrafficDirection.WEST)
        );
    }

    @Test
    void TestResumeInterSection(){
        interSection.pause();
        interSection.resume();
        assertFalse(interSection.isPaused());
        assertDoesNotThrow(
                ()->interSection.SetGreen(TrafficDirection.WEST)
        );
    }

    @Test
    void TestPreventConcurrencyConflictGreen() throws InterruptedException {
        Thread t1=new Thread(()->interSection.SetGreen(TrafficDirection.NORTH));
        Thread t2=new Thread(()->{
            try{
                interSection.SetGreen(TrafficDirection.EAST);
            }catch (Exception ignored){}
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long greencount=interSection.getLights().values().stream().filter(
                light->light
                        .getTrafficLightColor()==TrafficLightColor.GREEN
                )
                .count();
        assertEquals(1,greencount);

    }
}
