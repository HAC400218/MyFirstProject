package com.trafficlight.sys;

import com.trafficlight.sys.controller.TrafficLightController;
import com.trafficlight.sys.service.InterSection;
import com.trafficlight.sys.service.TrafficLightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.ResponseEntity.status;

@SpringBootTest
@WebMvcTest(TrafficLightController.class)
class TrafficApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private TrafficLightService trafficLightService;

	@Test
	void testCreateInterSections() {
//		InterSection mockResponse=new InterSection("T1");
//		//matching the service call in your controller
//		when(trafficLightService.TrafficLightService("T1")).thenReturn(mockResponse);
////		mockMvc.perform(post("/intersection/api/T1")
////				.contentType(MediaType.APPLICATION_JSON))
////				.andExpect(status().isCreated());
//
//		verify(trafficLightService).TrafficLightService("T1");
	}

}
