
public class cal {
  public static int[] calculator(int num1, int num2) {
    int plus = num1 + num2;
    int minus = num1 - num2;
    int mul = num1 * num2;
    int div = num1 / num2;
    return new int[] {plus, minus, mul, div};
  }
  public static int calculator(String operator, int fn, int sn) {
    int result;
    if (operator.equals("+")) {
      result = fn + sn;
    } else if (operator.equals("-")) {
      result = fn - sn;
    } else if (operator.equals("*")) {
      result = fn * sn;
    } else if (operator.equals("/")) {
      result = fn / sn;
    } else {
      result = fn % sn;
    }
    return result;
  };
}