import java.util.HashSet;
import java.util.Scanner;

public class InputReader {
  private Scanner scanner;

  public InputReader() {
    scanner = new Scanner(System.in);
  }

  public HashSet<String> getInput() {
    System.out.println("");
    System.out.print("> ");
    String input = scanner.nextLine().trim().toLowerCase();

    String[] wordArr = input.split(" ");

    HashSet<String> tokens = new HashSet<>();
    for (String word : wordArr) {
      tokens.add(word);
    }

    return tokens;
  }
}
