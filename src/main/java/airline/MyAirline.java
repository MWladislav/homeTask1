package airline;

import entity.Airplane;
import entity.PassengerAirplane;
import entity.TransportAirplane;
import org.apache.log4j.Logger;
import util.comparator.AirplaneComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyAirline {

    private static Logger LOGGER = Logger.getLogger(MyAirline.class);

    private ArrayList<Airplane> airplanes;

    public MyAirline(ArrayList<Airplane> airplains) {
        this.airplanes = airplains;

    }

    public List<Airplane> getAirplains() {
        return airplanes;
    }

    /**
     * @return total passenger capasity of airport
     */
    public int calculateTotalPassengerCapasity(){
        //int totalCapasity=0;
        ArrayList<PassengerAirplane> passengerAirplanes = new ArrayList<>();
        for (Airplane a:airplanes) {
            if(a instanceof PassengerAirplane){
                passengerAirplanes.add((PassengerAirplane) a);
                //LOGGER.info("add airplane to list passengerAirpanes");
            }
        }
        return passengerAirplanes.stream().mapToInt(PassengerAirplane::getNumberOfSeats).sum();
    }

    /**
     * @return total weight that all airplanes lift up in airport
     */
    public int calculateTotalLoadCapasity(){
        ArrayList<TransportAirplane> transportAirplanes = new ArrayList<>();
        for (Airplane a:airplanes) {
            if(a instanceof TransportAirplane){
                transportAirplanes.add((TransportAirplane) a);
                //LOGGER.info("add airplane to list transportAirpanes");
            }
        }
        int totalCapasity = transportAirplanes.stream().mapToInt(TransportAirplane::getLoadCapasity).sum();
        //add weight of all passengers in passenger airplanes to total load capasity
        //62 - average person weight
        totalCapasity+=calculateTotalPassengerCapasity()*62;
        return totalCapasity;
    }

    /**
     * Sort airport airplanes, using AiplaneComparator
     */
    public void sortByFlightDistance(){
        AirplaneComparator comparator = new AirplaneComparator();
        this.airplanes.sort(comparator);
    }

    /**
     *
     * @param fuelConsumptionMin left limit of the range
     * @param fuelConsumptionMax right limit of the range
     * @return list of airplanes that satisfy the given range
     */
    public List<Airplane> searchByFuelConsumption(final int fuelConsumptionMin, int fuelConsumptionMax){

        if (fuelConsumptionMax<fuelConsumptionMin) {
            LOGGER.error("Wrong range");
            return null;
        }

        List<Airplane> suitableAirplanes;

        //for (Airplane plane:this.airplanes) {
        //    if (plane.getFuelConsumption() >= fuelConsumptionMin && plane.getFuelConsumption() <=fuelConsumptionMax)
        //        suitableAirplanes.add(plane);
        //}

        suitableAirplanes = airplanes.stream().filter(ap -> ap.getFuelConsumption() >=fuelConsumptionMin)
                .filter(ap -> ap.getFuelConsumption() <=fuelConsumptionMax).collect(Collectors.toList());


        if(suitableAirplanes.size()==0){
            LOGGER.info("No one airplane satisfy the given arguments");
            return null;
        }
        LOGGER.info(suitableAirplanes.size()+" airplane(s) satisfy this range");
        return suitableAirplanes;

    }
}