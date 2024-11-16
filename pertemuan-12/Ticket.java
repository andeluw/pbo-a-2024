import java.util.ArrayList;
import java.util.List;

public class Ticket {
  protected List<String> facilities;
  protected double baseFare;
  protected int baggageLimit;

  public Ticket(double baseFare) {
    this.baseFare = baseFare;
    facilities = new ArrayList<>();
  }

  public double calculateFare() {
    return baseFare;
  }

  public List<String> getFacilities() {
    return facilities;
  }

  public void printFacilities() {
    System.out.println("Facilities:");
    for (int i = 0; i < facilities.size(); i++) {
      System.out.println((i + 1) + ". " + facilities.get(i));
    }
  }

  public void addFacility(String facility) {
    facilities.add(facility);
  }

  public int getBaggageLimit() {
    return baggageLimit;
  }

  public void printTicketDetails() {
    System.out.printf("Price: $%.2f\n", calculateFare());
    System.out.println("Baggage Limit: " + getBaggageLimit() + " kg");
    printFacilities();
  }

  public static void main(String[] args) {
    double fare = 500;
    EconomyTicket economyTicket = new EconomyTicket(fare);
    BusinessTicket businessTicket = new BusinessTicket(fare);
    FirstClassTicket firstClassTicket = new FirstClassTicket(fare);

    System.out.println("- Economy Ticket -");
    economyTicket.printTicketDetails();

    System.out.println("\n- Business Ticket -");
    businessTicket.printTicketDetails();

    System.out.println("\n- First Class Ticket -");
    firstClassTicket.printTicketDetails();
  }
}