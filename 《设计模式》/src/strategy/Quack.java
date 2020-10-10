package strategy;

public class Quack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("嘎嘎嘎嘎");
  }
}
