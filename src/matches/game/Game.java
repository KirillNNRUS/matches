package matches.game;

import matches.players.Player;

public abstract class Game {
  final int MAX_REMOVE_MATCHES = 3;
  final int MIN_REMOVE_MATCHES = 1;

  public abstract GameOptions getGAME_OPTIONS();

  public int getMAX_REMOVE_MATCHES() {
    return MAX_REMOVE_MATCHES;
  }

  public int getMIN_REMOVE_MATCHES() {
    return MIN_REMOVE_MATCHES;
  }

  public abstract void setPlayers(Player[] players);

  public abstract int getMatchesNow();

  public abstract void setMatchesNow(int matchesNow);

  public abstract void startGame();
}
