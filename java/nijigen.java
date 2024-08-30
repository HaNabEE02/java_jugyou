import java.util.Scanner;

public class nijigen {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("행개수 : ");
    int row = sc.nextInt();
    System.out.print("열개수 : ");
    int col = sc.nextInt();
    int arr[][] = new int[row][col];
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int k = 0; k < arr[0].length; k++) {
        arr[i][k] = ++sum;
      }
    }
    for (int[] rowValue : arr) {
      for (int colValue : rowValue) {
        System.out.print(colValue + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}
