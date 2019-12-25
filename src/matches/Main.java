package matches;

import matches.console.ConsoleOutput;

import java.util.Scanner;

public class Main {
  static int select = -1;
  static boolean isScannerInputValid = false;
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    ConsoleOutput consoleOutput = new ConsoleOutput();

    consoleOutput.consoleOutput(
        "Здравствуйте!", "Поиграем в 20 спичек??", "\r\n", "0 - если Да", "1 - если Нет");

    consoleOutput.consoleOutput("Ваш выбор?");
    scannerInputToInt();
    setIsScannerInputValidBeginGame();

    while (!isScannerInputValid) {
      consoleOutput.consoleOutput("0 - если Да", "1 - если Нет");
      scannerInputToInt();
      setIsScannerInputValidBeginGame();
    }
  }

  public static void setIsScannerInputValidBeginGame() {
    if (select == 1) {
      isScannerInputValid = true;

      return;
    }

    if (select == 0) {
      isScannerInputValid = true;
      return;
    }

    isScannerInputValid = false;
  }

  public static void scannerInputToInt() {
    // Знаю, что можно in.nextInt(), но почему то потом перестает снова заходить в блок try, если
    // найду почему переделаю
    String temp = in.nextLine();

    try {
      select = Integer.parseInt(temp);
    } catch (Exception e) {
      System.out.println("Введите число");
    }
  }
}
