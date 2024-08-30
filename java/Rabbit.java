public class Rabbit {
  String shape;
  String color;
  int xPos;
  int yPos;
  
  Rabbit(int x, int y) {
  xPos = x;
    yPos = y;
    color = "Blue";
    shape = "default";
  }

  Rabbit() {
    color = "Yellow";
    shape = "default";
  }

  Rabbit(String c, String s, int x, int y) {
    color = c;
    shape = s;
    xPos = x;
    yPos = y;

  }

  void move(int dx, int dy) {
    xPos += dx;
    yPos += dy;
  }

  int getXPos() {
    return xPos;
  }

  int getYPos() {
    return yPos;
  }

}

class MountainRabbit extends Rabbit {
  String mountain;
  void eatWildglass() {
    System.out.println("풀 뜯는 토끼");
  }
  MountainRabbit() {
    shape = "mountainRabbit";
  }
  void move (int dx, int dy) {
    xPos += dy;
    yPos += dx;
  }
}

class HouseRabbit extends Rabbit {
  String house;
  void eatFeed() {
    System.out.println("사료 먹는 토끼");
  }
  HouseRabbit() {
    shape = "HouseRabbit";
  }
  void move (int dx, int dy) {
    xPos = dx;
    yPos = dy;
    if (xPos >= 100) {
      xPos = 100;
    } 
    if (yPos >= 100) {
      yPos = 100;
    }
  }
}