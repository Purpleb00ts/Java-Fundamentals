import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");

        String[] secondInput = scanner.nextLine().split(" ");

        for (int i = 0; i < secondInput.length; i++) {
            for (int j = 0; j < firstInput.length; j++) {
                if(secondInput[i].equals(firstInput[j]))
                {
                    System.out.printf("%s ", secondInput[i]);
                }
            }
        }
        System.out.println();
    }
}
