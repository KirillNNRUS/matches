package matches.players;

import matches.game.Game;

public class Machine extends Player {
  private String name;
  private final int FIRST_STEP = 3;
  //Не придумал название поэтому SOME_VALUE, которое равно "4"  и позволяет найти mustBeMatchesForWin для компа
  private final int SOME_VALUE = 4;
  private int stepAfterFirst = 1;
  private int mustBeMatchesForWin;

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
    if (game.getMatchesNow() == game.getMAX_MATCHES()) {

      return FIRST_STEP;
    }
    findMustBeMatchesForWin(game);
    return game.getMatchesNow() - mustBeMatchesForWin;
  }

  private void findMustBeMatchesForWin(Game game) {
    mustBeMatchesForWin = (game.getMAX_MATCHES() - FIRST_STEP) - (SOME_VALUE * stepAfterFirst);
    stepAfterFirst++;
  }

  @Override
  public String getName() {
    return name;
  }
}
