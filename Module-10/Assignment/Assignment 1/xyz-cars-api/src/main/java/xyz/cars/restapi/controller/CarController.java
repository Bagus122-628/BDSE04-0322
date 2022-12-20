package xyz.cars.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.cars.restapi.entity.Car;
import xyz.cars.restapi.models.CarDto;
import xyz.cars.restapi.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarController {

  @Autowired
  private CarService carService;

  // List Car
  @GetMapping("")
  public List<Car> listCar() throws Exception {
    List<Car> listCar = carService.listCar();
    return listCar;
  }

  // Car Detail
  @GetMapping("/{idCar}")
  public Car carDetail(@PathVariable("idCar") int idCar) throws Exception {
    Car carDetail = carService.getCarById(idCar);
    return carDetail;
  }

  // Post Car
  @PostMapping("/post")
  public Car postCar(@RequestBody CarDto carDto) throws Exception {
    Car newCar = carService.saveCarPost(carDto);
    return newCar;
  }

  // Search By Keyword
  @GetMapping(value = "", params = "keyword")
  public List<Car> searchCar(@RequestParam("keyword") String keyword, Model model) throws Exception {
    List<Car> searchCar = carService.searchByKeyword(keyword);
    return searchCar;
  }

  // Search By Price Range
  @GetMapping(value = "", params = { "min", "max" })
  public List<Car> searchCarByPriceRange(@RequestParam("min") int min, @RequestParam("max") int max, Model model)
      throws Exception {
    List<Car> searchCar = carService.searchByPriceRange(min, max);
    return searchCar;
  }
}
