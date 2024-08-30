import java.util.Random;
import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    int rdInt = rd.nextInt(101);
    int count = 0;
    int answer = -1;
    do {
      System.out.printf("숫자를 입력해주세요 : ");
      answer = sc.nextInt();
      if (answer > rdInt) {
        System.out.println("작아야 됌");
        System.out.printf("숫자를 입력해주세요 : ");
        answer = sc.nextInt();
        count++;
      } else if (answer < rdInt) {
        System.out.println("커야 됌");
        System.out.printf("숫자를 입력해주세요 : ");
        answer = sc.nextInt();
        count++;
      } else {
        System.out.printf("정답임, 시도 횟수 : %d", count);
      }
    } while (rdInt != answer);

    sc.close();
  }
}