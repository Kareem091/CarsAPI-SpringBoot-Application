package com.evolvice.cars.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.evolvice.cars.api.common.CustomResponse;
import com.evolvice.cars.api.entities.Cars;
import com.evolvice.cars.api.repository.CarsRepository;


/*
 * REST API endpoint with CRUD functionality on cars Created by SpringBoot on Java 1.8 running on local PORT 8089
 * used it to list, delete, update and add new car.
 * Authentication user/pass = evolvice/evolvice
 * JSON
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CarsController {

	@Autowired
	private CarsRepository carsRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(CarsController.class);

	/*
	 * below request used to adding new car to the system 
	 * REST URL: http://localhost:8089/api/addCar
	 * Method: PUT
	 * Response Codes: Success (200 OK), System Error (9999)
	 */
	@PutMapping("/addCar")
	private ResponseEntity<CustomResponse> addCar(@Valid @RequestBody Cars carRequest) {
		LOGGER.info("Entering addCar : " + carRequest);
		ResponseEntity<CustomResponse> buildResponse = null;
		try {
			Cars savedCar = carsRepo.insert(carRequest);
			LOGGER.info("Car requestBody saved : " + savedCar.getId());
			if (savedCar != null) {
				buildResponse =  new ResponseEntity<CustomResponse>(new CustomResponse("Car Saved Successfully ", "200", savedCar), HttpStatus.OK);
			}
		} catch (Exception e) {
			buildResponse = new ResponseEntity<CustomResponse>(new CustomResponse("System Error ", "9999", null),HttpStatus.EXPECTATION_FAILED);
		}
		return buildResponse;
		
	}

	
	/*
	 * below request used to list all cars in the system
	 * REST URL: http://localhost:8089/api/listCars
	 * Method: GET
	 * Response Codes: Success (200 OK), Internal Server Error (500)
	 */
	@GetMapping("/listCars")
	private List<Cars> getAllCars() {
		LOGGER.info("Entering getAllCars: ");
		List<Cars> carList = carsRepo.findAll();
		return carList;

	}

	/*
	 * below request used to Update car exist in the system by id
	 * REST URL: http://localhost:8089/api/updateCarId/{carID}
	 * URL Params : Required: carID=[String]
	 * Method: POST
	 * Response Codes: Success (200 OK), Internal Server Error (500)
	 */
	@PostMapping("/updateCarId/{carId}")
	private ResponseEntity<CustomResponse> updateCar(@PathVariable("carId") String carId, @RequestBody Cars carRequest) {
		LOGGER.info("Entering updateCar: ID: " + carId + " RequestBody :: " + carRequest);
		Cars car = carsRepo.findById(carId).orElseThrow(() -> new IllegalArgumentException("Invalid Car Id:" + carId));
		car.setCarBrand(carRequest.getCarBrand());
		car.setCarModel(carRequest.getCarModel());
		car.setCarModelDetails(carRequest.getCarModelDetails());
		car.setCarPrice(carRequest.getCarPrice());
		car.setCarProductionYear(carRequest.getCarProductionYear());
		carsRepo.save(car);
		return new ResponseEntity<CustomResponse>(new CustomResponse("Car Updated Successfully ", "200", car), HttpStatus.OK);


	}
	
	/*
	 * below request used to Update car exist in the system by id
	 * REST URL: http://localhost:8089/api/updateCarId/{carID}
	 * URL Params : Required: carID=[String]
	 * Method: POST
	 * Response Codes: Success (200 OK), Internal Server Error (500)
	 */
	@PostMapping("/updateCarIdV2/{carId}")
	private ResponseEntity<CustomResponse> updateCarV2(@PathVariable("carId") String carId, @RequestBody Cars carRequest) {
		LOGGER.info("Entering updateCar: ID: " + carId + " RequestBody :: " + carRequest);
		Cars car = carsRepo.findById(carId).orElseThrow(() -> new IllegalArgumentException("Invalid Car Id:" + carId));
		car.setCarBrand(carRequest.getCarBrand());
		car.setCarModel(carRequest.getCarModel());
		car.setCarModelDetails(carRequest.getCarModelDetails());
		car.setCarPrice(carRequest.getCarPrice());
		car.setCarProductionYear(carRequest.getCarProductionYear());
		carsRepo.save(car);
		return new ResponseEntity<CustomResponse>(new CustomResponse("Car Updated Successfully ", "200", car), HttpStatus.OK);


	}

	
	/*
	 * below request used to remove car from the system by id
	 * REST URL: http://localhost:8089/api/removeCar/{carID}
	 * URL Params : Required: carID=[String]
	 * Method: DELETE
	 * Response Codes: Success (200 OK), Internal Server Error (500)
	 */
	@DeleteMapping("/removeCar/{carId}")
	private ResponseEntity<CustomResponse> removeCar(@PathVariable("carId") String carId) {
		LOGGER.info("Entering removeCar: " + carId);
		Cars car = carsRepo.findById(carId).orElseThrow(() -> new IllegalArgumentException("Invalid Car Id: " + carId));
		carsRepo.delete(car);
		return new ResponseEntity<CustomResponse>(new CustomResponse("Car Removed Successfully ", "200", car), HttpStatus.OK);

	}
	
	/*
	 * below request used to remove car from the system by id
	 * REST URL: http://localhost:8089/api/removeCar/{carID}
	 * URL Params : Required: carID=[String]
	 * Method: DELETE
	 * Response Codes: Success (200 OK), Internal Server Error (500)
	 */
	@DeleteMapping("/removeCarV2/{carId}")
	private ResponseEntity<CustomResponse> removeCarV2(@PathVariable("carId") String carId) {
		LOGGER.info("Entering removeCar: " + carId);
		Cars car = carsRepo.findById(carId).orElseThrow(() -> new IllegalArgumentException("Invalid Car Id: " + carId));
		carsRepo.delete(car);
		return new ResponseEntity<CustomResponse>(new CustomResponse("Car Removed Successfully ", "200", car), HttpStatus.OK);

	}

}
