public class CommandWords {
  private static final String allowedCommands[] = { "go", "quit", "help" };

  public CommandWords() {

  }

  public boolean isAllowedCommand(String inputCommand) {
    for (String command : allowedCommands) {
      if (command.equals(inputCommand))
        return true;
    }
    return false;
  }
}
