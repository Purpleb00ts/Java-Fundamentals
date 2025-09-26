import java.util.Arrays;
import java.util.Scanner;

public class MapToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String input = sc.nextLine();

        String[] inputArr = input.split(" ");

        int[] numbersArr = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
        //int[] numbersArr = Arrays.stream(sc.nextLine().split( regex: " ")).mapToInt(e -> Integer.parseInt(e)).toArray(); same as above
        // e is for element can be anything else for example f, d, z etc.
    }
}
