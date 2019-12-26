package matches.players;

import matches.game.Game;

public class Machine extends Player {
  private String name;

  public Machine(String name) {
    this.name = name;
  }

  @Override
  public void setMatchesNow(Game game, int value) {
    game.setMatchesNow(value);
  }

  @Override
  public int getMatchesNow(Game game) {
    return game.getMatchesNow();
  }

  @Override
  public int removeMatches(Game game) {
    // IDEA предлагает заменить на if, но не буду
    switch (game.getGAME_OPTIONS()) {
      case TWENTY_MATCHES:
        return removeMatchesTwentyMatches(game);
    }
    return 0;
  }

  @Override
  public String getName() {
    return name;
  }

  int removeMatchesTwentyMatches(Game game) {
    if (game.getMatchesNow() == 20) {
      return 3;
    }
    if (game.getMatchesNow() > 13) {
      return game.getMatchesNow() - 13;
    }
    if (game.getMatchesNow() > 9) {
      return game.getMatchesNow() - 9;
    }
    if (game.getMatchesNow() > 5) {
      return game.getMatchesNow() - 5;
    }
    if (game.getMatchesNow() > 1) {
      return game.getMatchesNow() - 1;
    }
    return 0;
  }
}
