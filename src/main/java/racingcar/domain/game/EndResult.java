package racingcar.domain.game;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class EndResult extends GameResult {

  public EndResult(GameSet gameSet) {
    super(gameSet);
  }

  private Map<Integer, List<Car>> groupByLength() {
    return this.gameSet.getCars().stream().collect(Collectors.groupingBy(Car::getPosition));
  }

  private int getMaxLength() {
    return this.gameSet.getCars().stream().mapToInt(Car::getPosition).distinct().max()
        .orElseThrow(NoSuchElementException::new);
  }

  private List<Car> getWinners() {
    return groupByLength().get(getMaxLength());
  }

  private void printCarsScore() {
    this.gameSet.getCars().forEach(System.out::println);
  }

  private void printWinners() {
    System.out.println("최종 우승자 : " +
        getWinners().stream()
            .map(Car::getName)
            .collect(Collectors.joining(",")));
  }

  @Override
  public void showResult() {
    printCarsScore();
    printWinners();
  }
}
