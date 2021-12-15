package racingcar.domain.game;

public class RandomGameRule implements GameRule {

  @Override
  public boolean canMove(GameSet gameSet) {
    return true;
  }
}
