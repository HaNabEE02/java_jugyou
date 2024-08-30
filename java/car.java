public class car {
  String type;
  String color = "deafult";
  int speed = 0;
  int accel = 0;

  car() {
  }

  car (String t, String c, int s, int ac) {
    type = t;
    color = c;
    speed = s;
    accel = ac;
  }

  car (String t) {
    type = t;
  }

  int acCar(int ac) {
    accel = ac;
    speed += accel;
    if (speed >= 200) {
      speed = 200;
    }
    if (speed <= 0) {
      speed = 0;
    }
    return speed;
  }


}

class oogataCar extends car {
  int acCar(int ac) {
    accel = ac;
    speed += accel;
    if (speed >= 60) {
      speed = 60;
    }
    if (speed <= 0) {
      speed = 0;
    }
    return speed;
  }
}

class sportCar extends car {
  int acCar(int ac) {
    accel = ac;
    speed += accel;
    if (speed <= 0) {
      speed = 0;
    }
    return speed;
  }
}