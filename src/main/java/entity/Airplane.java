package entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public abstract class Airplane {

    //Flight distance of airplane in km
    @Min(value = 0, message = "Flight distance should not be less than 0")
    @Max(value = 15000, message = "Flight distance should not be greater than 15000")
    private int flightDistance;
    //Fuel consumption of airplane in l/100km
    @Min(value = 0, message = "Fuel consumption should not be less than 0")
    @Max(value = 1000, message = "Fuel consumption should not be greater than 1000")
    private int fuelConsumption;

    private AirplaneManufacturers manufacturer;

    Airplane(int flightDistance, int fuelConsumption, AirplaneManufacturers manufacturer) {
        this.flightDistance = flightDistance;
        this.fuelConsumption = fuelConsumption;
        this.manufacturer = manufacturer;
    }

    public int getFlightDistance() {
        return flightDistance;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public AirplaneManufacturers getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "manufacturer=" + manufacturer+
                "flightDistance=" + flightDistance +
                ", fuelConsumption=" + fuelConsumption;
    }
}
