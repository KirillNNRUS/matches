package matches;

import matches.console.ConsoleInput;
import matches.console.ConsoleOutput;
import matches.game.Game;
import matches.game.GameTwentyMatches;
import matches.players.Human;
import matches.players.Machine;
import matches.players.Player;

public class Main {
  static int select = -1;
  static boolean isScannerInputValid = false;
  static Player[] players = new Player[2];
  static Game game;

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
      // создаю GameTwentyMatches, но можно создать расширить вариации игры в дальнешем
      game = GameTwentyMatches.getInstance();
      game.setPlayers(players);
      game.startGame();
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
    players[0] = new Machine("Компьютер");
    players[1] = new Human("Человек");
  }
}
