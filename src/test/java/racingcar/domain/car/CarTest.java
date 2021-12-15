package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void 잘못된_이름을_가진_차_소환() {
    assertThrows(IllegalArgumentException.class, () -> {
      Car invalidNameCar = new Car("123456");
    });
  }

  @Test
  void 자동차는_이동한다() {
    Car fancyCar = new Car("Divo");

    Car movedFancyCar = fancyCar.move(1);

    assertEquals(0, new Car("K8").move(1).compareTo(movedFancyCar));
  }

  @Test
  void 자동차의_현재_위치를_출력한다() {
    Car car = new Car("a");

    Car movedCar = car.move(5);

    assertEquals("a : -----", movedCar.toString());
  }
}
