import java.util.Scanner;
public class password {
  static boolean passwordCheck (String password) {
    if (password.length() < 8) {
      return false;
    }
    for (int i = 0; i < password.length(); i ++) {
      char pwd = password.charAt(i);
      if(!Character.isAlphabetic(pwd)) {
        return false;
      };
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("확인하고 싶은 패스워드를 입력해주세요 : ");
    String pwd = sc.nextLine();
    if (passwordCheck(pwd)) {
      System.out.println("올바른 패스워드 입니다.");
    }else {
      System.out.println("올바르지 않은 패스워드 입니다.");
    }
    sc.close();
  }
}
