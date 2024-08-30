import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class fileR {
    public static void main(String[] args) {
        String filePath = "D:/java/myData2.txt";

        try (
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            Scanner sc = new Scanner(System.in, "UTF-8");
        ) {
            String initialMessage = "초기 메시지";
            bw.write(initialMessage);
            bw.newLine(); 

            String c;
            while (true) {
                System.out.print("추가 할 내용 입력 (종료하려면 빈 문자열 입력) : ");
                c = sc.nextLine();
                if (c.isEmpty()) {
                    break;
                }
                bw.write(c);
                bw.newLine(); 
            }

            System.out.println("파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
