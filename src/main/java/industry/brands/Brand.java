package industry.brands;

import industry.vehicle.car.Car;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Brand {
  static List<Brand> brands = new ArrayList<>();
  String name;
  List<Car> cars = new ArrayList<>();
  int foundationYear = 1920;
  String history;

  private Brand(String name) {
    this.name = name;
  }

  public static Brand @NotNull [] getBrands() {
    return brands.toArray(new Brand[0]);
  }

  @org.jetbrains.annotations.NotNull
  public static Brand getInstance(String name) {
    for (Brand brand : brands) {
      if (brand.name.equals(name)) {
        return brand;
      }
    }
    Brand newBrand = new Brand(name);
    brands.add(newBrand);
    return newBrand;
  }

  public void addCar(Car car) {
    cars.add(car);
  }

  public Car[] getCars() {
    return cars.toArray(new Car[0]);
  }

  public int getFoundationYear() {
    return foundationYear;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Brand {" + '\n' +
          "          name: " + name + '\n' +
          "          cars: " + cars.toString() + '\n' +
          "          foundation: " + foundationYear + '\n' +
          "          history: " + history + '\n' +
          "        }";
  }

}
