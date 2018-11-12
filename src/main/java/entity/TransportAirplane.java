package entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class TransportAirplane extends Airplane {

    //Load capasity of transport airplane in kg
    @Min(value = 0, message = "Load capasity of transport airplane should not be less than 0")
    @Max(value = 220000,message = "Load capasity of transport airplane should not be greater than 220000")
    private int loadCapasity;

    public TransportAirplane(int flightDistance, int fuelConsumption,AirplaneManufacturers manufacturer, int loadCapasity) {
        super(flightDistance, fuelConsumption,manufacturer);
        this.loadCapasity = loadCapasity;
    }

    public int getLoadCapasity() {
        return loadCapasity;
    }

    public void setLoadCapasity(int loadCapasity) {
        this.loadCapasity = loadCapasity;
    }

    @Override
    public String toString() {
        return "TransportAirplane:" + super.toString() +
                "loadCapasity=" + loadCapasity;
    }
}
