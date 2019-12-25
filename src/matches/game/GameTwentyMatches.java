package matches.game;

import matches.players.Player;

public class GameTwentyMatches extends Game {
  private final int MAX_MATCHES = 20;
  int matchesNow;
  Player[] players;
  Player nextPlayer;

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

  public Player getNextPlayer() {
    return nextPlayer;
  }

  public void setNextPlayer(Player nextPlayer) {
    this.nextPlayer = nextPlayer;
  }

  public GameTwentyMatches(int matchesNow, Player[] players, Player nextPlayer) {
    this.matchesNow = matchesNow;
    this.players = players;
    this.nextPlayer = nextPlayer;
  }

  void gameBegin() {
      matchesNow = MAX_MATCHES;
  }
}
