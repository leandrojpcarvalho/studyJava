package industry.vehicle.car;

import industry.bodywork.BodyWork;
import industry.brands.Brand;

public class Car extends AbstractCar {

  public Car(String name, String brand, String model, int year) {
    try {
      setName(name);
      setModel(model);
      setBrand(brand);
      setYear(year);
      AbstractCar.AddCar(this);
    } catch (IllegalArgumentException e) {
      System.out.println(e.toString());
    }
  }

  public Car() {
  }

  public void setBrand(String brand) {
    Brand brandInstance = Brand.getInstance(brand);
    this.brand = brandInstance.getName();
    brandInstance.addCar(this);
  }

  public String getBrand() {
    return brand != null ? brand : null;
  }

  public void setModel(String model) {
    this.model = BodyWork.getInstance(model);
  }

  public String  getModel() {
    return model != null ? model.toString(): null;
  }

  public void setName(String name) {
    if (AbstractCar.isExistentCar(name) == null) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("This name is not Available: " + AbstractCar.getCarInstance(name).toString());
    }
  }

  public String getName() {
    return name;
  }

  public void setYear(int year) {
    Brand brand = Brand.getInstance(getBrand());
    if (year < brand.getFoundationYear()) {
      throw new IllegalArgumentException("Impossible! this date is before the company was founded: " + brand.getFoundationYear());
    }
    this.year = year;
  }

  public int getYear() {
    return year;
  }
}
