import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parser {
  private CommandWords command;
  private BufferedReader reader;
  private StringTokenizer tokenizer;

  public Parser() {
    command = new CommandWords();
    reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public Command getCommand() {
    String input = "", firstWord, secWord;
    System.out.print("> ");

    try {
      input = reader.readLine();
    } catch (java.io.IOException exception) {
      System.out.println("There was an error: " + exception.getMessage());
    }

    tokenizer = new StringTokenizer(input);

    if (tokenizer.hasMoreTokens()) {
      firstWord = tokenizer.nextToken();
    } else {
      firstWord = null;
    }

    if (tokenizer.hasMoreTokens())
      secWord = tokenizer.nextToken();
    else
      secWord = null;

    if (command.isAllowedCommand(firstWord))
      return new Command(firstWord, secWord);
    else
      return new Command(null, secWord);
  }
}
