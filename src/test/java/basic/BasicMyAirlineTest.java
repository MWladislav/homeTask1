package basic;

import airline.MyAirline;
import entity.Airplane;
import entity.AirplaneManufacturers;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

public abstract class BasicMyAirlineTest {

    protected MyAirline airline;

    @BeforeMethod
    protected void getAirplanePool(){

        PassengerAirplane boeing737 = new PassengerAirplane
                (2518,150,AirplaneManufacturers.BOEING,114);

        PassengerAirplane a310 = new PassengerAirplane
                (4000,180,AirplaneManufacturers.AIRBUS,183);

        PassengerAirplane mrj = new PassengerAirplane
                (1480,210,AirplaneManufacturers.MITSUBISHI_AIRCRAFT_CORPORATION,70);

        TransportAirplane a300_600st = new TransportAirplane
                (5000,100,AirplaneManufacturers.AIRBUS,47000);

        TransportAirplane c17 = new TransportAirplane
                (7000,200,AirplaneManufacturers.BOEING,76000);



        airline =  new MyAirline(new ArrayList<Airplane>(){
            {
                this.add(boeing737);
                this.add(a310);
                this.add(mrj);
                this.add(a300_600st);
                this.add(c17);
            }
        });

    }
}
