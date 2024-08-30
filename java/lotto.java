import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MAX_NUMBER = 45;

    public static int[] lotto_make() {
        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        // 중복되지 않는 번호 6개 생성
        while (numbers.size() < LOTTO_NUMBER_COUNT) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            numbers.add(number); // Set에 추가하면 자동으로 중복이 제거됨
        }

        // Set을 배열로 변환
        int[] result = new int[LOTTO_NUMBER_COUNT];
        int index = 0;
        for (int num : numbers) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] lottoNumbers = lotto_make();
        System.out.print("Generated Lotto Numbers: ");
        for (int num : lottoNumbers) {
            System.out.print(num + " ");
        }
    }
}