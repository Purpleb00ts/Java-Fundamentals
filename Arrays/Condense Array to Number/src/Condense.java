import java.util.Arrays;
import java.util.Scanner;

public class Condense {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        while(inputArr.length > 1)
        {
            int[] condensed = new int[inputArr.length - 1];
            for (int i = 0; i < inputArr.length - 1; i++) {
                condensed[i] = inputArr[i] + inputArr[i+1];
            }
            inputArr = condensed;
        }
        System.out.println(inputArr[0]);
    }
}
