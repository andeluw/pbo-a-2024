public class FirstClassTicket extends Ticket {
  public FirstClassTicket(double baseFare) {
    super(baseFare);
    baggageLimit = 40;
    addFacility("Private suites with fully flat beds and luxury bedding.");
    addFacility("Chef-prepared meals with champagne and premium wines.");
    addFacility("Personal 20” screens with exclusive content and live TV.");
    addFacility("Unlimited high-speed Wi-Fi and premium noise-canceling headphones.");
    addFacility("Onboard shower and exclusive lounge bar.");
    addFacility("Chauffeur service and expedited airport security.");
  }

  @Override
  public double calculateFare() {
    return baseFare * 1.5;
  }
}