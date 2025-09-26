import java.util.Scanner;
public class SumOfOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        int odd = 1;
        for(int i = 0; i < n; i++)
        {
            sum += odd;
            System.out.println(odd);
            odd += 2;
        }
        System.out.println(sum);
    }
}
