package xyz.cars.restapi.service;

import java.util.List;

import xyz.cars.restapi.entity.Car;
import xyz.cars.restapi.models.CarDto;

public interface CarService {

  public List<Car> listCar() throws Exception;

  public Car getCarById(int idCar) throws Exception;

  public Car saveCarPost(CarDto carDto) throws Exception;

  public List<Car> searchByKeyword(String keyword) throws Exception;

  public List<Car> searchByPriceRange(int min, int max) throws Exception;
}
