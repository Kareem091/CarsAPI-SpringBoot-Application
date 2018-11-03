package com.evolvice.cars.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.evolvice.cars.api.entities.Cars;

public interface CarsRepository extends MongoRepository<Cars, String> {

}
