import java.util.Scanner;

public class scor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] score = new int[5];
    float avg;
    int sumScore = 0;
    System.out.println("김연아 끝");
    for (int i = 0; i < score.length; i++) {
      System.out.printf("점수 입력 : ");
      score[i] = sc.nextInt();
      sumScore += score[i];
    }
    int max = score[0];
    int min = score[0];
    for (int value : score) {
      if (max < value) {
        max = value;
      }
      if (min > value) {
        min = value;
      }
    }
    System.out.printf("최댓값 : %d \n최소값 : %d \n", max, min);
    avg = (float) sumScore / score.length;

    System.out.printf("김연아 점수 : %d \n", sumScore);
    System.out.printf("김연아 평균점수 : %.2f \n", avg);

    sc.close();
  }
}
