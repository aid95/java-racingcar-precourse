package racingcar;

import racingcar.domain.game.Game;
import racingcar.domain.game.GameFactory;

public class Application {

  public static void main(String[] args) {
    Game game = GameFactory.getInstance().newGame();
    game.run();
  }
}
