import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int topInteger = 0;



        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if(input[i] <= input[j]) {
                    break;
                }
                if(j == input.length - 1)
                {
                    topInteger = input[i];
                    System.out.printf("%d ", topInteger);
                }
            }
        }
        System.out.printf("%d", input[input.length - 1]);
    }
}
