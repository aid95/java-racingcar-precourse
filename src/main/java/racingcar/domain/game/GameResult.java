package racingcar.domain.game;

public abstract class GameResult {

  protected GameSet gameSet;

  protected GameResult(GameSet gameSet) {
    this.gameSet = gameSet;
  }

  abstract void showResult();
}
