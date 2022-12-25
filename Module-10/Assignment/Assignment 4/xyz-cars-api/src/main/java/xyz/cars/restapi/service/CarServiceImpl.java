package xyz.cars.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.cars.restapi.entity.Car;
import xyz.cars.restapi.entity.UserAccount;
import xyz.cars.restapi.models.CarDto;
import xyz.cars.restapi.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

  @Autowired
  private CarRepository carRepo;
  @Autowired
  private UserService userService;

  @Override
  public Car getCarById(int idCar) throws Exception {
    Car car = carRepo.findById(idCar).get();
    return car;
  }

  @Override
  public List<Car> listCar() throws Exception {
    List<Car> listCar = carRepo.findAll();
    return listCar;
  }

  @Override
  public Car saveCarPost(CarDto carDto) throws Exception {
    Car newCar = new Car();
    UserAccount user = userService.getUserById(carDto.getIdUser());

    newCar.setMake(carDto.getMake());
    newCar.setModel(carDto.getModel());
    newCar.setYear(carDto.getYear());
    newCar.setPrice(carDto.getPrice());
    newCar.setUser(user);

    carRepo.save(newCar);

    return newCar;
  }

  @Override
  public List<Car> searchByKeyword(String keyword) throws Exception {
    List<Car> listCar = carRepo.searchCarByKeyword(keyword);

    return listCar;
  }

  @Override
  public List<Car> searchByPriceRange(int min, int max) throws Exception {
    List<Car> listCar = carRepo.searchCarByPriceRange(min, max);

    return listCar;
  }

}
