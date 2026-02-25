package com.trafficlight.sys.controller;

import com.trafficlight.sys.model.TrafficDirection;
import com.trafficlight.sys.service.InterSection;
import com.trafficlight.sys.service.TrafficLightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
class TrafficLightControllerTest {

    @InjectMocks
    private TrafficLightController trafficLightController;

    @Mock
    private TrafficLightService trafficLightService;

    @Test
    void testCreateInterSection_returns201() throws Exception {
        String id = "T1";
        InterSection expected = new InterSection("T1");
        when(trafficLightService.TrafficLightService(eq(id)))
                .thenReturn(expected);
        ResponseEntity<?> response = trafficLightController.createInterSections(id);
        assertNotNull(response.getBody());
        assertEquals(201, response.getStatusCode().value());
        verify(trafficLightService, times(1)).TrafficLightService(eq(id));
        verifyNoMoreInteractions(trafficLightService);
    }


    @Test
    void testChangeColorGreen_return204(){

        String intersectionId = "T1";
        TrafficDirection direction = TrafficDirection.NORTH;
        doNothing().when(trafficLightService)
                .changeLightColor(intersectionId, direction);
        ResponseEntity<?> response =trafficLightController.changeTrafficColorGreen(intersectionId,direction);
        assertEquals(204, response.getStatusCode().value());
    }


    @Test
    void testCurrentState_returnsOkAndBody() {

        String intersectionId = "T1";
        InterSection dto = new InterSection(intersectionId);
        when(trafficLightService.getIntersections(intersectionId)).thenReturn(dto);
        ResponseEntity<?> response = trafficLightController.getCurrentState(intersectionId);
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());

    }


    @Test
    void testChangePause_return204() throws Exception {

        String intersectionId = "T1";
        doNothing().when(trafficLightService).changePause(intersectionId);
        ResponseEntity<?> response =trafficLightController.changePause(intersectionId);
        assertEquals(204, response.getStatusCode().value());
    }

    @Test
    void testChangeResume_return204() throws Exception {
        String intersectionId = "T1";
        doNothing().when(trafficLightService).changeResume(intersectionId);
        ResponseEntity<?> response =trafficLightController.changeResume(intersectionId);
        assertEquals(204, response.getStatusCode().value());
    }




}