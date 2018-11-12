import entity.Airplane;
import entity.AirplaneManufacturers;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.comparator.AirplaneComparator;

public class AirplaneComparatorTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][] { { 1, 2, -1 }, { 5, 5, 0 }, {4, 1, 3} };
    }

    @Test(dataProvider = "data")
    public void testCompare(int a, int b, int expectedResult) {

        //GIVEN
        Airplane airplaneA = new TransportAirplane(a,0,AirplaneManufacturers.AIRBUS,0);

        Airplane airplaneB = new PassengerAirplane(b,0,AirplaneManufacturers.ANTONOV,0);

        AirplaneComparator comparator = new AirplaneComparator();

        // WHEN
        int result = comparator.compare(airplaneA, airplaneB);

        //THEN
        Assert.assertEquals(expectedResult, result);

    }

}
