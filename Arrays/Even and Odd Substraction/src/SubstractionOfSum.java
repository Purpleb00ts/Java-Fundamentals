import java.util.Arrays;
import java.util.Scanner;

public class SubstractionOfSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine();

        int[] inputArr = Arrays.stream(input.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < inputArr.length; i++) {
            if(inputArr[i] % 2 == 0) {
                sumEven += inputArr[i];
            }
            else{
                sumOdd += inputArr[i];
            }
        }

        int subtraction = sumEven - sumOdd;

        System.out.println(subtraction);
    }
}
