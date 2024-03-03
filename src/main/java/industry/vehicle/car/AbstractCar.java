package industry.vehicle.car;

import industry.bodywork.BodyWork;

import java.util.ArrayList;
import java.util.List;

public class AbstractCar {
  private static final List<Car> cars = new ArrayList<>();
  String name;
  String brand;
  BodyWork model;
  int year;

  AbstractCar(){
  }

  static Car getCarInstance(String carName) {
    Car  car = isExistentCar(carName);
    if (car != null) {
      return car;
    }
    Car newCar = new Car();
    newCar.setName(carName);
    cars.add(newCar);
    return newCar;
  }

  static void AddCar(Car car) {
    cars.add(car);
  }

  static Car isExistentCar(String name) {
    for (Car car : cars) {
      if (car.name.equals(name)){
        return car;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "Car {" + '\n' +
          "       name: " + name + '\n' +
          "       brand: " + brand + '\n' +
          "       model: " + model + '\n' +
          "       year: " + year + '\n' +
          "    }";
  }
}
