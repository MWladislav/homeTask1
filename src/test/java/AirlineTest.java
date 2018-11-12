import basic.BasicMyAirlineTest;
import entity.Airplane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AirlineTest extends BasicMyAirlineTest {

    @Test
    public void calcPassengerCapasity(){

        int result = airline.calculateTotalPassengerCapasity();

        Assert.assertEquals(result,367);
    }

    @Test
    public void calcLoadCapasity(){

        int result = airline.calculateTotalLoadCapasity();

        Assert.assertEquals(result,145_754);
    }

    @Test
    public void searchByFuelConsumptionTest() {
        List<Airplane> airplanes = airline.searchByFuelConsumption(180, 210);
        String result = airplanes.get(0).getManufacturer().toString();
        result += airplanes.get(1).getManufacturer().toString();
        Assert.assertEquals("AIRBUSMITSUBISHI_AIRCRAFT_CORPORATION", result);
    }

    @Test
    public void searchByFuelConsumptionIncorrectTest() {
        List<Airplane> cars = airline.searchByFuelConsumption(210, 180);
        Assert.assertNull(cars);
    }
}
