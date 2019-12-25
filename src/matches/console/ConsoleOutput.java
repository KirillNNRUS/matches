package matches.console;

public class ConsoleOutput {
  public void consoleOutput(String... text) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String value : text) {
      stringBuilder.append(" ").append(value);
    }
    System.out.println(stringBuilder);
  }
}
