public class Command {
  private String commandWord;
  private String extraWord;

  public Command(String commandWord, String extraWord) {
    this.commandWord = commandWord;
    this.extraWord = extraWord;
  }

  public String getCommandWord() {
    return commandWord;
  }

  public String getExtraWord() {
    return extraWord;
  }

  public boolean isUnknownCommand() {
    return (commandWord == null);
  }

  public boolean hasExtraWord() {
    return (extraWord != null);
  }
}