import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        boolean flag = false;

        if(input.length == 1)
        {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = i; j >= 0; j--) {
                sumLeft += input[j];
            }
            for (int k = i; k < input.length; k++) {
                sumRight += input[k];
            }
            if(sumLeft == sumRight)
            {
                flag = true;
                System.out.println(i);
            }
        }
        if(!flag)
        {
            System.out.println("no");
        }
    }
}
