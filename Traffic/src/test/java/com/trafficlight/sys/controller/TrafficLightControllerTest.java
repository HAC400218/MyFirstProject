package com.trafficlight.sys.controller;

import com.trafficlight.sys.service.TrafficLightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//@WebMvcTest(TrafficLightController.class)
public class TrafficLightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrafficLightService trafficLightService;


    @Test
    void TestCreateInterSection() throws Exception{
        doNothing().when(trafficLightService).TrafficLightService("T1");
        mockMvc.perform(post("/intersections/api/T1")).andExpect(status().isCreated());
    }
}
