package util.comparator;

import entity.Airplane;

import java.util.Comparator;

public class AirplaneComparator implements Comparator<Airplane> {

    public int compare(Airplane a, Airplane b){
        return a.getFlightDistance() - b.getFlightDistance();
    }

}
