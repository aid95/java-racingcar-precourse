package racingcar.domain.game;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class GameSet implements Iterator<GameSet> {

  public final int currentRound;
  public final int totalRound;
  public List<Car> cars;

  public List<Car> getCars() {
    return Collections.unmodifiableList(cars);
  }

  public GameSet(int round, List<Car> cars) {
    this(round, cars, 0);
  }

  private GameSet(int round, List<Car> cars, int currentRound) {
    this.cars = cars;
    this.totalRound = round;
    this.currentRound = currentRound;
  }

  private boolean isLastSet() {
    return currentRound >= (totalRound - 1);
  }

  private GameResult genGameResult() {
    if (isLastSet()) {
      return new EndResult(this);
    }
    return new PlayResult(this);
  }

  public GameResult play(GameRule gameRule) {
    Function<Car, Car> applyRuleFunc = (Car car) -> {
      if (gameRule.canMove(this)) {
        return car.move(1);
      }
      return car.move(0);
    };

    cars = this.cars.stream()
        .map(applyRuleFunc)
        .collect(Collectors.toList());
    return genGameResult();
  }

  @Override
  public boolean hasNext() {
    return currentRound < totalRound;
  }

  @Override
  public GameSet next() {
    return new GameSet(totalRound, cars, currentRound + 1);
  }
}
