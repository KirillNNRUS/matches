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
  static boolean isFirstGame = true;
  static Player[] players = new Player[2];
  static Game game;
  static ConsoleOutput consoleOutput = new ConsoleOutput();
  static ConsoleInput consoleInput = new ConsoleInput();

  public static void main(String[] args) {
    startGame();

    consoleInput.scannerClose();
  }

  public static void startGame() {
    do {
      if (isFirstGame) {
        consoleOutput.consoleOutput(
            "Здравствуйте!", "Поиграем в 20 спичек??", "\r\n", "1 - если Да.", "0 - если Нет");
        isFirstGame = !isFirstGame;
        consoleOutput.consoleOutput("Ваш выбор?");
        select = consoleInput.scannerInputToInt();
        setIsScannerInputValidBeginGame();

        while (!isScannerInputValid) {
          consoleOutput.consoleOutput("1 - если Да.", "0 - если Нет");
          select = consoleInput.scannerInputToInt();
          setIsScannerInputValidBeginGame();
        }
      }

      if (select == 1) {
        addPlayersForNewGame();
        // создаю GameTwentyMatches, но можно создать расширить вариации игры в дальнешем, например
        // увеличив количество спичек.
        game = GameTwentyMatches.getInstance();
        game.setPlayers(players);
        game.startGame();
        game.stopGame();
        consoleOutput.consoleOutput("Хотите сыграть еще раз??");
        consoleOutput.consoleOutput("1 - если Да.", "0 - если Нет");
        select = consoleInput.scannerInputToInt();
        setIsScannerInputValidBeginGame();
      } else {
        return;
      }
    } while (select == 1);
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
