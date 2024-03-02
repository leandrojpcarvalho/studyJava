package main.vehicle;

import main.brands.Brand;

import java.util.ArrayList;
import java.util.List;

public class AbstractVehicle {
  static List<AbstractVehicle> vehicles = new ArrayList<>();
  private String name;
  private int year;
  private Brand brand;
  private VehicleType type;

  static AbstractVehicle[] getAllVehicles() {
    return vehicles.toArray(new AbstractVehicle[0]);
  }

  static void addNewVehicle(AbstractVehicle vehicle) {
    if(!vehicles.contains(vehicle)) {
      vehicles.add(vehicle);
    } else  {
      throw new IllegalArgumentException("this vehicle exists use method getVehicle");
    }
  }
}
