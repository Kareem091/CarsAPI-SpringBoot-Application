package com.evolvice.cars.api.common;

import com.evolvice.cars.api.entities.Cars;

public class CustomResponse {

	private String sucessMessage;
	private String msgCode;
	private Cars car;
	
	public CustomResponse(String sucessMessage,String msgCode,Cars car) {
		this.sucessMessage = sucessMessage;
		this.msgCode = msgCode;
		this.car = car;
	}

	public String getSucessMessage() {
		return sucessMessage;
	}
	
	public String getMsgCode(){
		return msgCode;
	}
	
	public Cars getCar(){
		return car;
	}

}
