import java.util.Arrays;
import java.util.Scanner;

public class SumEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String numbers = sc.nextLine();
        // 1 2 3 4 5 6
        //1.) int[] numArr = new int[sc.nextLine().split(" ").length];
//      2.)  String[] inputArr = numbers.split(" ");
//
//        int[] numArr = new int[inputArr.length];
//
//        for (int i = 0; i < numArr.length; i++) {
//            numArr[i] = Integer.parseInt(inputArr[i]);
//        }
        // 3.)
        int[] numbersArr = Arrays.stream(numbers.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;

        for (int i = 0; i < numbersArr.length; i++) {

            if(numbersArr[i] % 2 == 0)
            {
                sum += numbersArr[i];
            }
        }
        System.out.println(sum);
    }
}
