import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] reverseThis = new int[n];

        for (int i = 0; i < reverseThis.length; i++)
        {
            reverseThis[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = reverseThis.length - 1; i >= 0; i--)
        {
            System.out.println(reverseThis[i]);
        }
    }
}
