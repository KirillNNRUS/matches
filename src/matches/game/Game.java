package matches.game;

public abstract class  Game {
  final int WIN = 1;
  final int MAX_REMOVE_MATCHES = 3;
  final int MIN_REMOVE_MATCHES = 1;
  public abstract void startGame();
  public abstract void stopGame();
}
