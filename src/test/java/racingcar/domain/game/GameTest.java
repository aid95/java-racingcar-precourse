package racingcar.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class GameTest {

  Game game;

  @BeforeEach
  void before() {
    int totalRound = 5;
    Car[] cars = new Car[]{
        new Car("1"),
        new Car("2"),
        new Car("3")
    };
    game = new Game(totalRound, cars);
  }

  @Test
  void testGamePlay() {
    game.run();
  }
}
