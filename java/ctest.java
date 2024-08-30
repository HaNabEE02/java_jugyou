import java.util.Scanner;

public class ctest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int acc;
    car c = new car("truck");
    oogataCar oCar = new oogataCar();
    for (int i = 0; i <= 5; i++) {
      System.out.print("\n 추가 할 속도 : ");
      acc = sc.nextInt();
      c.acCar(acc);
      oCar.acCar(acc);
      System.out.printf("현재 차의 속도 %d \n", c.speed);
      System.out.printf("현재 oCar의 속도는 %d \n", oCar.speed);
    }
    sc.close();
    tank t = new tank();
    t.move();
    t.fire();
  }
}
