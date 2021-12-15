package racingcar.domain.game;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;

public class Game {

  private final int totalRound;
  private final List<Car> cars;

  public Game(int totalRound, Car... cars) {
    this.totalRound = totalRound;
    this.cars = Arrays.asList(cars);
  }

  public void run() {
    playing();
  }

  private void playing() {
    GameSet gameSet = new GameSet(totalRound, cars);
    while (gameSet.hasNext()) {
      GameResult result = gameSet.play(new RandomGameRule());
      result.showResult();
      gameSet = gameSet.next();
    }
  }
}
