package test.vehicle.car;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import main.brands.Brand;
import main.vehicle.car.Car;

public class TestCar extends TestCase {
  String name = "eco sport";
  String brand = "ford";
  String model = "SUV";
  int year = 2007;

  public TestCar() {
    super("Class Car test");
  }

  public static Test suite() {
    return new TestSuite(TestCar.class);
  }

  public void testCarConstructorWithParams() {
//    its test if is possible create a car with all attributes

    Car ecoSport = new Car(name, brand, model, year);

    assertEquals(ecoSport.getName(), name);
    assertEquals(ecoSport.getYear(), year);
    assertEquals(ecoSport.getModel(), model);
    assertEquals(ecoSport.getBrand(), brand);
  }

  public void testCarConstructorWithoutParams() {
    Car car = new Car();
    assertNull(car.getName());
    assertNull(car.getBrand());
    assertNull(car.getModel());
    assertEquals(car.getYear(), 0);
  }

  public void testSetMethods() {
    Car car = new Car();
    car.setName(name + "s");
    car.setBrand(brand);
    car.setModel(model);
    car.setYear(year);

    assertEquals(car.getName(), name + "s");
    assertEquals(car.getBrand(), brand);
    assertEquals(car.getModel(), model);
    assertEquals(car.getYear(), year);
  }

  public void testSetNameError() {
    Car car1 = new Car(name, brand, model, year);
    Car car2 = new Car("s", brand, model, year);
    try {
      car2.setName(name);
      fail("The expected exception is not thrown");
    } catch (IllegalArgumentException e) {
      assertEquals(
            e.toString(),
            "java.lang.IllegalArgumentException:" +
                  " This name is not Available: "
                  + car1.toString());
    }
  }

  public void testSetYearError() {
    Car car = new Car(name, brand, model, year);

    try {
      car.setYear(1919);
      fail("The expected exception is not thrown");
    } catch (IllegalArgumentException e) {
      assertEquals(
            e.toString(),
            "java.lang.IllegalArgumentException: " +
                  "Impossible! this date is before the company " +
                  "was founded: " +
                  Brand.getInstance(brand).getFoundationYear()
      );
    }

  }


}
