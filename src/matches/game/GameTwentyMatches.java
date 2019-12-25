package matches.game;

import matches.players.Player;

public class GameTwentyMatches extends Game {
  private static GameTwentyMatches instance;
  private final int MAX_MATCHES = 20;
  private final GameOptions GAME_OPTIONS = GameOptions.TWENTY_MATCHES;
  private int matchesNow;
  private Player[] players;

  @Override
  public int getMatchesNow() {
    return matchesNow;
  }

  @Override
  public void setMatchesNow(int matchesNow) {
    this.matchesNow = matchesNow;
  }

  @Override
  public GameOptions getGAME_OPTIONS() {
    return GAME_OPTIONS;
  }

  public void setPlayers(Player[] players) {
    this.players = players;
  }

  private GameTwentyMatches() {
    int minRemoveMatches = super.getMIN_REMOVE_MATCHES();
    int maxRemoveMatches = super.getMAX_REMOVE_MATCHES();
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
    System.out.println("Начало игры. Компьютер ходит первым! На столе 20 спичек");
    while (matchesNow > 1) {
      for (Player nextPlayer : players) {
        int matches = nextPlayer.getMatchesNow(this);

        if (matches == MAX_MATCHES) {
          System.out.println("Компьютер явно что-то задумал!");
        } else {
          System.out.println("Осталось спичек: " + matches);
        }

        int matchesMinus = nextPlayer.removeMatches(this);

        nextPlayer.setMatchesNow(this, matches - matchesMinus);

        System.out.println(nextPlayer.getName() + " делает ход. Убрано спичек: " + matchesMinus);

        if (matchesNow == 1) {
          System.out.println("К сожалению Компьютер выиграл");
          break;
        }
      }
    }
  }
}
