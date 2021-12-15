package racingcar.domain.car;

import java.util.Collections;

public class Car implements Comparable<Car> {

  private final String name;
  private int position = 0;

  public Car(String name) {
    this(name, 0);
  }

  private Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public Car move(int n) {
    return new Car(this.name, this.position + n);
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  private String drawBar() {
    return String.join("", Collections.nCopies(this.position, "-"));
  }

  @Override
  public int compareTo(Car o) {
    return this.position - o.position;
  }

  @Override
  public String toString() {
    return this.name + " : " + drawBar();
  }
}
