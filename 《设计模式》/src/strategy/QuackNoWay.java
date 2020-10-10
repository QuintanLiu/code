package strategy;

public class QuackNoWay implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("叫不出来");
  }
}
