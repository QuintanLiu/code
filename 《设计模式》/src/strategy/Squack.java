package strategy;

public class Squack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("嘤嘤嘤");
  }
}
