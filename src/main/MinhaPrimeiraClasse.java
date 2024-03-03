package main;

import industry.vehicle.car.Car;

public class MinhaPrimeiraClasse {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("eco sport", "ford", "SUV", 2007);
        Car car2 = new Car();

        car2.setBrand("ford");
        try {
            car2.setName("eco sport");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        System.out.println(car2.getName());
    }
}