import java.util.Scanner;

public class testtest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("계산 할 연산자를 선택 : +, -, *, /, %");
    String operator = sc.nextLine();
    System.out.print("first number : ");
    int fn = sc.nextInt();
    System.out.print("second number : ");
    int sn = sc.nextInt();
    int[] numArr = cal.calculator(fn, sn);
    System.out.println(cal.calculator(operator, fn, sn));
    System.out.printf("%d %d %d %d \n", numArr[0], numArr[1], numArr[2], numArr[3]);
    for(int value : numArr) {
      System.out.println(value);
    }
    sc.close();
  }
}
