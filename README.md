### A Spring Boot Application Assinment with Spring Data Rest and MongoDB
REST API endpoint with CRUD functionality on cars system.

### MongoDB Config.

* Database: carsdb
* Collections: cars
* url: localhost
* port: 27017

Note:... i use mlab.com/ - uri = mongodb://carsadmin:abcd1234@ds251223.mlab.com:51223/carsdb

### MongoDB schema.
```json	
db.cars.insert(
{
brand:"N/A",
model:"N/A",
modelDetails:"N/A",
productionYear:"###-##-##",
price:"00000"
}
)
```

### Tools

[Spring Boot](http://projects.spring.io/spring-boot/)

[MongoDB](https://www.mongodb.com/)

[Mlab mongodb](https://mlab.com/)


### Run the App!

1-mvn package spring-boot:run

2-main method exist in App class

### Urls

REST API is using basic authentication api to secure api calls:..

user/password: evolvice/evolvice

* [http://localhost:8089/api/addCar/](http://localhost:8089/api/addCar/)

Request Body:

```json	
{
    "carBrand": "BMW 2-series",
    "carModel": "230i",
    "carModelDetails": "The delightful 2-series coupe and convertible showcase BMW’s trademark performance in a pleasing package. The 230i gets an eager 248-hp 2.0-liter turbo inline-four and an eight-speed automatic; the coupe offers a no-charge six-speed manual. A smooth 335-hp 3.0-liter turbo inline-six powers the M240i, and it’s the car for drivers. Rear-wheel drive is standard; all-wheel drive is available. An optional Track Handling package—standard on the M240i—offers brake, suspension, and steering upgrades.",
    "carPrice": 32000,
    "carProductionYear": "2018-09-22"
}
```
* [http://localhost:8089/api/listCars](http://localhost:8089/api/listCars)

* [http://localhost:8089/api/removeCar/{carId}](http://localhost:8089/api/removeCar/{carId})

* [http://localhost:8089/api/updateCarId/{carId}](http://localhost:8089/api/updateCarId/{carId})


