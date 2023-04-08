public enum FlightRules {
    INSTRUMENT_FLIGHT_RULES(10),
    VISUAL_FLIGHT_RULES(20),
    SPECIAL_FLIGHT_RULES(15);

    private int minSeparation;

    FlightRules(int minSeparation) {this.minSeparation = minSeparation;}

    public int getMinSeparation() {
        return minSeparation;
    }
}
