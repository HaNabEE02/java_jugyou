import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecryptF {
    public static void main(String[] args) {
        String secureFilePath = "D:/java/secure.txt";
        String keyFilePath = "D:/java/key.txt";

        try (
            BufferedReader secureReader = new BufferedReader(new FileReader(secureFilePath));
            BufferedReader keyReader = new BufferedReader(new FileReader(keyFilePath))
        ) {
            StringBuilder decryptedText = new StringBuilder();
            List<Integer> keys = new ArrayList<>();
            String line;

            // 난수를 key.txt에서 읽어 List에 저장
            while ((line = keyReader.readLine()) != null) {
                keys.add(Integer.parseInt(line));
            }
            System.out.println(keys);
            // 암호화된 텍스트를 secure.txt에서 읽어 복호화
            int keyIndex = 0;
            while ((line = secureReader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (keyIndex < keys.size()) {
                        int key = keys.get(keyIndex++);
                        decryptedText.append((char) (c - key));
                        System.out.println(keyIndex);
                    } else {
                        // 난수가 부족한 경우 처리
                        System.out.println("난수 부족");
                        decryptedText.append(c);
                    }
                }
                decryptedText.append("\n"); // 줄 바꿈 문자 추가
            }

            // 복호화된 결과 출력
            System.out.println("Decrypted text:");
            System.out.println(decryptedText.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
