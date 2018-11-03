package com.evolvice.cars.api.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cars")
public class Cars {

	@Id
	private String id;
	@Field("brand")
	private String carBrand;
	@Field("model")
	private String carModel;
	@Field("modelDetails")
	private String carModelDetails;
	@Field("price")
	private double carPrice;
	@Field("productionYear")
	private Date carProductionYear;

	
	
	
	public Cars(String carBrand, String carModel, String carModelDetails, double carPrice, Date carProductionYear) {
		super();
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carModelDetails = carModelDetails;
		this.carPrice = carPrice;
		this.carProductionYear = carProductionYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarModelDetails() {
		return carModelDetails;
	}

	public void setCarModelDetails(String carModelDetails) {
		this.carModelDetails = carModelDetails;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public Date getCarProductionYear() {
		return carProductionYear;
	}

	public void setCarProductionYear(Date carProductionYear) {
		this.carProductionYear = carProductionYear;
	}

}
