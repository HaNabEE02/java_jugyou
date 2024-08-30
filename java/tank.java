interface Car1 {
  void move();
}

interface Cannon {
  void fire();
}

public class tank implements Car1, Cannon {
  public void move() {
    System.out.println("탱크는 움직인다.");
  };

  public void fire() {
    System.out.println("탱크는 대포쏜다.");
  };
}
