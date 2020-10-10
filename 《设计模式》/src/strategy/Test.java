package strategy;

public class Test {

  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.setFlyBehavior(new FlyBehavior() {
      @Override
      public void fly() {
        System.out.println("我是模型鸭，我要坐火箭上天！");
      }
    });
    mallard.setQuackBehavior(new Squack());
    mallard.display();
    mallard.performFly();
    mallard.performQuack();
    mallard.swim();

  }
}
