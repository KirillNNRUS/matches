package matches.players;

import matches.console.ConsoleInput;
import matches.console.ConsoleOutput;
import matches.game.Game;

public class Human extends Player {
  private ConsoleInput consoleInput = new ConsoleInput();
  private ConsoleOutput consoleOutput = new ConsoleOutput();
  private String name;
  private boolean isValidChoice;
  private int humanChoice = -1;
  private int maxChoice;
  private int minChoice;

  public Human(String name) {
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
    maxChoice = game.getMAX_REMOVE_MATCHES();
    minChoice = game.getMIN_REMOVE_MATCHES();
    humanChoice = -1;
    isValidChoice = false;
    humanChoice = consoleInput.scannerInputToInt();
    setValidChoice();
    while (!isValidChoice) {
      consoleOutput.consoleOutput("Введите число от " + minChoice + " до " + maxChoice);
      humanChoice = consoleInput.scannerInputToInt();
      setValidChoice();
    }

    return humanChoice;
  }

  void setValidChoice() {
    if (humanChoice > maxChoice) {
      isValidChoice = false;
      return;
    }
    if (humanChoice < minChoice) {
      isValidChoice = false;
      return;
    }
    isValidChoice = true;
  }

  @Override
  public String getName() {
    return name;
  }
}
