public class BusinessTicket extends Ticket {
  public BusinessTicket(double baseFare) {
    super(baseFare);
    baggageLimit = 30;
    addFacility("Lie-flat seats with 50” legroom and privacy dividers.");
    addFacility("Gourmet meals with wine and cocktail selection.");
    addFacility("Personal 15” touchscreens with premium content and noise-canceling headphones.");
    addFacility("Complimentary high-speed Wi-Fi.");
    addFacility("Access to Business Lounges.");
    addFacility("Priority boarding, check-in, and baggage handling.");
  }

  @Override
  public double calculateFare() {
    return baseFare * 1.25;
  }
}
