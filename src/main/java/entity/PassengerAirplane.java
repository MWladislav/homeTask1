package entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PassengerAirplane extends Airplane {

    //Load capasity of transport airplane in kg
    @Min(value = 0, message = "Number of seats of passenger airplane should not be less than 0")
    @Max(value = 900,message = "Number of seats of passenger airplane should not be greater than 900")
    private int numberOfSeats;


    public PassengerAirplane(int flightDistance, int fuelConsumption,AirplaneManufacturers manufacturer, int numberOfSeats) {
        super(flightDistance, fuelConsumption,manufacturer);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "PassengerAirplane:" + super.toString() +
                "numberOfSeats=" + numberOfSeats;
    }
}
