public class Game {
  private Parser parser;
  private Room currRoom;
  private Command userCommand;

  public Game() {
    parser = new Parser();
    initRooms();
  }

  public void initRooms() {
    Room outside, theatre, pub, lab, office;

    outside = new Room("outside the main entrance of the university");
    theatre = new Room("in the lecture theatre");
    pub = new Room("in the campus pub");
    lab = new Room("in the computing lab");
    office = new Room("in the computing admin office");

    outside.setExitRooms(null, theatre, lab, pub);
    theatre.setExitRooms(null, null, null, outside);
    pub.setExitRooms(null, outside, null, null);
    lab.setExitRooms(outside, office, null, null);
    office.setExitRooms(null, null, null, lab);

    currRoom = outside;
  }

  public void play() {
    welcomeMessage();
    boolean end = false;
    while (!end) {
      userCommand = parser.getCommand();
      end = processCommand(userCommand);
    }
    endMessage();
  }

  private void welcomeMessage() {
    System.out.println();
    System.out.println("Welcome to the Adventure!");
    System.out.println("To play, please type 'go <direction>', for example: go north");
    System.out.println("Type 'help' if you need help.");
    System.out.println("Type 'quit' to quit the game.");
    printCurrRoomInfo();
  }

  private void endMessage() {
    System.out.println();
    System.out.println("Thanks for playing.");
  }

  private void printCurrRoomInfo() {
    System.out.println();
    System.out.println("You are currently at " + currRoom.getDesc() + ".");
    System.out.print("Possible exits: ");
    if (currRoom.northExit != null)
      System.out.print("north ");
    if (currRoom.eastExit != null)
      System.out.print("east ");
    if (currRoom.southExit != null)
      System.out.print("south ");
    if (currRoom.westExit != null)
      System.out.print("west");
    System.out.println();
  }

  private boolean processCommand(Command command) {
    boolean wantToQuit = false;
    if (command.isUnknownCommand()) {
      System.out.println();
      System.out.println("I do not know what you mean. Please enter a valid command.");
      System.out.println("Valid commands are: go, quit, help");
      return false;
    }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help"))
      printHelp();
    if (commandWord.equals("go"))
      goToAnotherRoom(command);
    if (commandWord.equals("quit")) {
      wantToQuit = quitGame(command);
    }
    return wantToQuit;
  }

  public void printHelp() {
    System.out.println("You are lost.");
    System.out.println("Please enter one of these commands: go, quit, help");
  }

  public void goToAnotherRoom(Command command) {
    if (!command.hasExtraWord()) {
      System.out.println();
      System.out.println("Where do you want to go? Please specify the direction (north, west, south, east).");
      return;
    }

    String direction = command.getExtraWord();
    Room nextRoom = null;

    if (direction.equals("north"))
      nextRoom = currRoom.northExit;
    else if (direction.equals("east"))
      nextRoom = currRoom.eastExit;
    else if (direction.equals("south"))
      nextRoom = currRoom.southExit;
    else if (direction.equals("west"))
      nextRoom = currRoom.westExit;
    else {
      System.out.println();
      System.out.println("Please enter one of these following: north, east, south, west");
      return;
    }

    if (nextRoom == null) {
      System.out.println();
      System.out.println("You can't go to the " + direction + ". There is no door here.");
      return;
    } else {
      currRoom = nextRoom;
      printCurrRoomInfo();
    }
  }

  private boolean quitGame(Command command) {
    if (command.hasExtraWord()) {
      System.out.println();
      System.out.println("What do you want to quit?");
      System.out.println("To quit from the game, please type 'quit' only.");
      return false;
    }
    return true;
  }
}
