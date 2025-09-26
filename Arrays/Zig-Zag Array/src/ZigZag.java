import java.util.Arrays;
import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            firstArr[i] = arr[0];
            secondArr[i] = arr[1];
        }
        for (int i = 1; i < n; i+=2) {
            int temp = firstArr[i];
            firstArr[i] = secondArr[i];
            secondArr[i] = temp;

        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", firstArr[i]);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", secondArr[i]);
        }
    }
}
