class EconomyTicket extends Ticket {
  public EconomyTicket(double baseFare) {
    super(baseFare);
    baggageLimit = 20;
    addFacility("Comfortable reclining seats with 31” legroom.");
    addFacility("Complimentary snacks and non-alcoholic beverages.");
    addFacility("In-flight entertainment via personal 10” touchscreens.");
  }

  @Override
  public double calculateFare() {
    return baseFare * 0.9;
  }
}
