package matches.players;

import matches.game.Game;

public abstract class Player {
  public abstract void setMatchesNow(Game game, int value);

  public abstract int getMatchesNow(Game game);

  public abstract int removeMatches(Game game);

  public abstract String getName();
}
