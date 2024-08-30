import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class rtest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[][] rabbitData = {
        { "Green", "uuujihoon", "20", "40" },
        { "Red", "bunny", "30", "50" },
        { "Blue", "fluffy", "40", "60" },
        { "Yellow", "fuck", "10", "80" }
    };
    List<Rabbit> rabbits = new ArrayList<>();
    for (String[] data : rabbitData) {
      String shape = data[0];
      String name = data[1];
      int xPos = Integer.parseInt(data[2]);
      int yPos = Integer.parseInt(data[3]);
      Rabbit rabbit = new Rabbit(shape, name, xPos, yPos);
      rabbits.add(rabbit);
    }

    System.out.printf("動かすウサギを選択してください。\n");
    for (Rabbit rabbit : rabbits) {
      System.out.println(rabbit.shape);
    }
    System.out.println();
    String inputRs = sc.next();

    boolean found = false;
    for (Rabbit rabbit : rabbits) {
      if (rabbit.shape.equals(inputRs)) {
        rabbit.move(-30, -30);
        rabbit.shape = "modified";
        System.out.printf("選択したウサギは %dのXの位置、%dのYの位置にあり、%sの姿をしています。\n", rabbit.getXPos(), rabbit.getYPos(),
            rabbit.shape);
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("指定された形のウサギは見つかりませんでした。");
    }
    sc.close();
  }
}
