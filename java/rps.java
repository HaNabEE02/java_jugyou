import java.util.Random;
import java.util.Scanner;
class Rsp {

  Rsp() {
  }

  int[] results;
  Random r = new Random();

  void play(int a) {
    results = new int[a];
    for (int i = 0; i < results.length; i++) {
      int robotA = r.nextInt(3);
      int robotB = r.nextInt(3);
      if (robotA == robotB) {
        results[i] = 0; // 0 to same
      } else if (robotA + 1 == robotB || robotA == 2 && robotB == 0) {
        results[i] = 1; // 1 to winB
        // System.out.printf("winB, robotA : %d, robotB : %d \n", robotA, robotB);
      } else if (robotA - 1 == robotB || robotA == 0 && robotB == 2) {
        results[i] = 2; // 2 to winA
        // System.out.printf("winA, robotA : %d, robotB : %d \n", robotA, robotB);
      }
    }
  }

  int[] result() {
    int same = 0;
    int winA = 0;
    int winB = 0;
    for (int value : results) {
      if (value == 0) {
        same++;
      } else if (value == 1) {
        winB++;
      } else if (value == 2) {
        winA++;
      }
    }
    System.out.printf("winA : %d, winB : %d, same : %d \n", winA, winB, same);
    return new int[]{same, winA, winB};
    
  }
}

// sc.nextInt(); 이렇게 객체를 생성하고 sc 라는 접근자를 사용해서 접근하는 것과
// Math.random(); 직접 Math 에서 random을 가져오는 것과 차이가 있음
// sc.nextInt() 처럼 사용하는 경우에는 public void nextInt(){}; 이런식으로 되어있고
// Math.random(); 처럼 사용하는 경우에는 public static void random(){}; 이런식으로 되어있음.
// static 의 역할에 대해서 공부할 것.

public class rps {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Rsp rr = new Rsp();
    System.out.print("가위바위보 할 횟수 입력 : ");
    int round = sc.nextInt();
    rr.play(round);
    int[] rs = rr.result();
    System.out.printf("%d %d %d", rs[0], rs[1], rs[2]);
    sc.close();
  }
}
