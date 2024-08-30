import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class EncryptF {
    public static void main(String[] args) {
        String secureFilePath = "D:/java/secure.txt";
        String keyFilePath = "D:/java/key.txt";

        try (
                BufferedWriter secureWriter = new BufferedWriter(new FileWriter(secureFilePath));
                BufferedWriter keyWriter = new BufferedWriter(new FileWriter(keyFilePath));
                Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            String input;

            System.out.println("Enter text to encrypt. Type an empty line to finish.");
            System.out.print("Type the secure text: ");
            while (true) {
                System.out.print("Type the secure text: ");
                input = scanner.nextLine();
                if (input.equals("")) {
                    break;
                }

                StringBuilder encryptedText = new StringBuilder();

                for (char c : input.toCharArray()) {
                    int randomValue = random.nextInt(256); // 0~255 범위의 난수
                    keyWriter.write(randomValue + "\n"); // 난수를 key.txt에 저장
                    encryptedText.append((char) (c + randomValue)); // 문자 암호화
                }

                secureWriter.write(encryptedText.toString());
                secureWriter.newLine();
            }

            System.out.println("Encryption completed. Files are saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
