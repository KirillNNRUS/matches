package matches.game;

import matches.console.ConsoleOutput;
import matches.players.Player;

public class GameTwentyMatches extends Game {
  private static GameTwentyMatches instance;
  private final int MAX_MATCHES = 40; //Тут устанавливаем максимальное количество спичек
  private ConsoleOutput consoleOutput = new ConsoleOutput();
  private int matchesNow;
  private Player[] players;

  @Override
  public int getMAX_MATCHES() {
    return MAX_MATCHES;
  }

  @Override
  public int getMatchesNow() {
    return matchesNow;
  }

  @Override
  public void setMatchesNow(int matchesNow) {
    this.matchesNow = matchesNow;
  }

  public void setPlayers(Player[] players) {
    this.players = players;
  }

  private GameTwentyMatches() {
    matchesNow = MAX_MATCHES;
  }

  public static GameTwentyMatches getInstance() {
    if (instance == null) {
      instance = new GameTwentyMatches();
    }
    return instance;
  }

  @Override
  public void startGame() {
    consoleOutput.consoleOutput("Начало игры. Компьютер ходит первым! На столе 20 спичек");
    while (matchesNow > 1) {
      for (Player nextPlayer : players) {
        int matches = nextPlayer.getMatchesNow(this);

        if (matches == MAX_MATCHES) {
          consoleOutput.consoleOutput("Компьютер явно что-то задумал!");
        } else {
          consoleOutput.consoleOutput("Осталось спичек: " + matches);
        }

        int matchesMinus = nextPlayer.removeMatches(this);

        nextPlayer.setMatchesNow(this, matches - matchesMinus);

        consoleOutput.consoleOutput(
            nextPlayer.getName() + " делает ход. Убрано спичек: " + matchesMinus);

        if (matchesNow == 1) {
          consoleOutput.consoleOutput("К сожалению Компьютер выиграл");
          break;
        }
      }
    }
  }

  @Override
  public void stopGame() {
    instance = null;
  }
}
