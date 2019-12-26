package matches.console;

import java.util.Scanner;

public class ConsoleInput {
  private ConsoleOutput consoleOutput = new ConsoleOutput();
  Scanner in = new Scanner(System.in);

  public int scannerInputToInt() {
    // Знаю, что можно in.nextInt(), но почему то потом перестает снова заходить в блок try, если
    // найду почему переделаю
    String temp = in.nextLine();

    try {
      return Integer.parseInt(temp);
    } catch (Exception e) {
      consoleOutput.consoleOutput("Введите число");
    }
    return -1;
  }

  public void scannerClose() {
    in.close();
  }
}
