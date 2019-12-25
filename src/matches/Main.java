package matches;

import matches.console.ConsoleInput;
import matches.console.ConsoleOutput;
import matches.game.GameTwentyMatches;
import matches.players.Human;
import matches.players.Machine;
import matches.players.Player;

public class Main {
  static int select = -1;
  static boolean isScannerInputValid = false;
  static Player[] players = new Player[2];
  static GameTwentyMatches newGameTwentyMatches;

  public static void main(String[] args) {

    ConsoleOutput consoleOutput = new ConsoleOutput();
    ConsoleInput consoleInput = new ConsoleInput();

    consoleOutput.consoleOutput(
        "Здравствуйте!", "Поиграем в 20 спичек??", "\r\n", "0 - если Да", "1 - если Нет");

    consoleOutput.consoleOutput("Ваш выбор?");
    select = consoleInput.scannerInputToInt();
    setIsScannerInputValidBeginGame();

    while (!isScannerInputValid) {
      consoleOutput.consoleOutput("0 - если Да", "1 - если Нет");
      select = consoleInput.scannerInputToInt();
      setIsScannerInputValidBeginGame();
    }
    if (select == 1) {
      addPlayersForNewGame();
      newGameTwentyMatches = GameTwentyMatches.getInstance();
      newGameTwentyMatches.setPlayers(players);
      newGameTwentyMatches.startGame();
    }
    consoleInput.scannerClose();
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

  public static void addPlayersForNewGame() {
    players[0] = new Machine();
    players[1] = new Human();
  }
}
