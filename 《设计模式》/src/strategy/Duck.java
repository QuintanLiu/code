package strategy;

public abstract class Duck {
  private FlyBehavior flyBehavior;
  private QuackBehavior quackBehavior;

  public abstract void display();

  public void performFly(){
    flyBehavior.fly();
  }

  public void performQuack () {
    quackBehavior.quack();
  }


  public void swim () {
    System.out.println("所有鸭子都会游泳");
  }

  public void setFlyBehavior(FlyBehavior flyBehavior) {
    this.flyBehavior = flyBehavior;
  }

  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
