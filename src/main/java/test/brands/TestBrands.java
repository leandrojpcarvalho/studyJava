package test.brands;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import industry.brands.Brand;
import industry.vehicle.car.Car;

public class TestBrands extends TestCase {
  private final String[] brands = {"ford", "volksvagem", "fiat", "ferrari", "ferrari"};

  public TestBrands() {
    super("Class Brand test");
  }

  public static Test suite() {
    return new TestSuite(TestBrands.class);
  }

  public void testGetInstance() {
//    its test if the method return a singleton instance
    Brand ford = Brand.getInstance(brands[0]);
    Brand fordCopy = Brand.getInstance(brands[0]);

    assertEquals(fordCopy, ford);
  }

  public void testGetCars() {
    Brand ford = Brand.getInstance(brands[0]);
    assertEquals(ford.getCars().length, 0);
  }

  public void testGetAllInstances() {
//    its test if the method return all singleton instances
    for (String brand : brands) {
      Brand.getInstance(brand);
    }

    Brand[] allBrands = Brand.getBrands();
    assertEquals(4, allBrands.length);
    for (int index = 0; index < brands.length - 1; index += 1) {
      assertEquals(Brand.getInstance(brands[index]), allBrands[index]);
    }
  }


  public void testAddCar() {
//    its test if when you create new car with brand adds an instance of car in the attribute cars
    Car ecoSport = new Car("eco sport", brands[0], "SUV", 2007);


    Car[] allCars = Brand.getInstance(brands[0]).getCars();
    assertEquals(allCars.length, 1);

    boolean exists = false;
    for (Car car : allCars) {
      if (car.equals(ecoSport)) {
        exists = true;
        break;
      }
    }
    assertTrue(exists);
  }
}
