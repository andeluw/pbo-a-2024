import java.util.Scanner;

class TicketMachine {
  private int price;
  private int balance;
  private int total;

  public TicketMachine(int ticketCost) {
    this.price = ticketCost;
    this.balance = 0;
    this.total = 0;
  }

  public int getBalance() {
    return balance;
  }

  public int getPrice() {
    return price;
  }

  public int getTotal() {
    return total;
  }

  public void insertMoney(int amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Money inserted successfully: " + amount);
      System.out.println("Current balance: " + balance);
    } else {
      System.out.println("The amount of money inserted must be a positive value!");
    }
  }

  public void printTicket() {
    if (balance >= price) {
      total += price;
      balance -= price;
      System.out.println("---- Ticket Successfully Printed! ----");
      System.out.println("---- Remaining Balance: " + balance + " ----");
      System.out.println("---- Thank you for using our service! ----");

    } else {
      System.out.println(
          "Sorry, you don't have enough balance to proceed. You need to insert " + (price - balance) + " more.");
    }
  }

  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);

    System.out.print("Enter the ticket price: ");
    int ticketPrice;
    while (true) {
      ticketPrice = inp.nextInt();
      if (ticketPrice <= 0) {
        System.out.println("The ticket price must be a positive value!");
      } else
        break;
    }

    TicketMachine machine = new TicketMachine(ticketPrice);

    while (true) {
      System.out.println("\n===== Ticket Machine Menu =====");
      System.out.println("1) Insert Money");
      System.out.println("2) Purchase and Print 1 Ticket");
      System.out.println("3) Check Current Balance");
      System.out.println("4) Exit");
      System.out.println("===============================");
      System.out.print("Please select an option (1, 2, or 3): ");
      int option = inp.nextInt();

      switch (option) {
        case 1:
          System.out.print("Enter amount: ");
          int amount = inp.nextInt();
          machine.insertMoney(amount);
          break;
        case 2:
          machine.printTicket();
          break;
        case 3:
          System.out.println("Current balance: " + machine.getBalance());
          break;
        case 4:
          System.out.println("Thank you for using the ticket machine.");
          System.out.println("Your final balance is: " + machine.getBalance());
          inp.close();
          return;
        default:
          System.out.println("Invalid choice, please try again.");
      }
    }
  }
}