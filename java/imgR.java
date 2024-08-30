import java.io.FileInputStream;
import java.io.FileOutputStream;

public class imgR {
  public static void main(String[] args) throws Exception{
    FileInputStream fis = new FileInputStream("D:/java/testt.jpg");
    FileOutputStream fos = new FileOutputStream("D:/java/test1.jpg");
    int ch;

    while((ch = fis.read()) != -1) {
      fos.write(ch);
    }
    fis.close();
    fos.close();
  }
}
