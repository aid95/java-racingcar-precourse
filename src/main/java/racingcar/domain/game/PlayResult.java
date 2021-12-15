package racingcar.domain.game;

public class PlayResult extends GameResult {

  public PlayResult(GameSet gameSet) {
    super(gameSet);
  }

  @Override
  public void showResult() {
    this.gameSet.getCars().forEach(System.out::println);
  }
}
