package racingcar.domain.game;

import java.util.Arrays;
import racingcar.domain.car.Car;

public class GameFactory {

  private GameFactory() {
  }

  private static class InnerInstanceClazz {

    private static final GameFactory instance = new GameFactory();
  }

  public static GameFactory getInstance() {
    return InnerInstanceClazz.instance;
  }

  public Game newGame() {
    return new Game(1, makeCars(inputName()));
  }

  private String[] inputName() {
    return new String[]{"a", "b", "c"};
  }

  private Car[] makeCars(String[] names) {
    return Arrays.stream(names).map(Car::new).toArray(Car[]::new);
  }
}
