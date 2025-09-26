import java.util.Scanner;
public class ArraysPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[] numbers = new int[5];

        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
