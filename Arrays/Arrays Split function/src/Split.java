import java.util.Scanner;

public class Split {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // "2 8 30 25 40 72 -2 44 56"
        String input = sc.nextLine();

        // gotta be the same separator in this case its a single space

        String[] inputArr = input.split(" ");

        int[] numbers = new int[inputArr.length];

        // "2" "8" "30" "25" "40" "72" "-2" "44" "56" still string values

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }
        // 2 8 30 25 40 72 -2 44 56 parsed to integers

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

    }
}
