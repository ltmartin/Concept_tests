import static java.lang.System.out;

public class Main {

    public static void main(String[] args){
        out.println(calculate(FlightRules.INSTRUMENT_FLIGHT_RULES));
    }

    private static int calculate(FlightRules flightRules) {
        return flightRules.getMinSeparation();
    }

}
