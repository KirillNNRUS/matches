package matches.game;

import matches.players.Player;

public class GameTwentyMatches extends Game {
  private static GameTwentyMatches instance;
  private final int MAX_MATCHES = 20;
  private final GameOptions GAME_OPTIONS = GameOptions.TWENTY_MATCHES;
  private int matchesNow;
  private Player[] players;


  public int getMatchesNow() {
    return matchesNow;
  }

  public void setMatchesNow(int matchesNow) {
    this.matchesNow = matchesNow;
  }

  public Player[] getPlayers() {
    return players;
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
    while (matchesNow > 1) {
      for (Player nextPlayer : players) {
        System.out.println(nextPlayer.toString());
      }
    }
  }

  @Override
  public void stopGame() {
    instance = null;
  }
}
