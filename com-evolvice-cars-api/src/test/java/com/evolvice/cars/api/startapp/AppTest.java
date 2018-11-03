package com.evolvice.cars.api.startapp;


import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.evolvice.cars.api.entities.Cars;


/*
 * 
 * adding integeration test on API
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate("evolvice","evolvice");
	HttpHeaders headers = new HttpHeaders();
	
	
	
	@Test
	public void addCarTest() {
		System.err.println("addCar Test Start...");
		Cars c = new Cars("Honda", "Civic", "J-car Details", 18000, new Date());
		HttpEntity<Cars> entity = new HttpEntity<Cars>(c, headers);
			ResponseEntity<String> response = restTemplate.exchange(buildAPIURI("/api/addCar"),HttpMethod.PUT, entity, String.class);
			System.out.println("addCarTest run and completed Sucessfully... and response is: " + response.getBody());
	}

	
	private String buildAPIURI(String uri) {
		return "http://localhost:" + port + uri;
	}

}