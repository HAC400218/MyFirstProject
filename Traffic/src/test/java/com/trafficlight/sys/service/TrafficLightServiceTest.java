package com.trafficlight.sys.service;

import com.trafficlight.sys.model.TrafficDirection;
import com.trafficlight.sys.model.TrafficLightColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class TrafficLightServiceTest {
	private TrafficLightService trafficLightService;
	@BeforeEach
	void setup(){
		trafficLightService=new TrafficLightService();
	}

	@Test
	void testCreateInterSections() {
		InterSection interSection=trafficLightService.TrafficLightService("T1");
		assertNotNull(interSection);
		assertEquals("T1",interSection.getId());
	}

	@Test
	void testChangeLightService(){
		trafficLightService.TrafficLightService("T1");
		trafficLightService.changeLightColor("T1", TrafficDirection.NORTH);
		InterSection interSection=trafficLightService.getIntersections("T1");
		assertEquals(TrafficDirection.NORTH
				,interSection
						.getLights()
						.entrySet()
						.stream()
						.filter(e->e.getValue().getTrafficLightColor().equals(TrafficLightColor.GREEN))
						.findFirst()
						.get()
						.getKey()
		);

	}
}
