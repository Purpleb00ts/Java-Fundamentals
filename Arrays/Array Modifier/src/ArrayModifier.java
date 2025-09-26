import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String commands = scanner.nextLine();

        while(!commands.equals("end")){
            String[] command = commands.split(" ");
            int firstElement = 0;
            int secondElement = 0;
            if(command.length > 1) {
                firstElement = Integer.parseInt(command[1]);
                secondElement = Integer.parseInt(command[2]);
            }

            if(command[0].equals("swap"))
            {
                int temp = inputArr[firstElement];
                inputArr[firstElement] = inputArr[secondElement];
                inputArr[secondElement] = temp;
            }
            if(command[0].equals("multiply"))
            {
                inputArr[firstElement] *= inputArr[secondElement];
            }
            if(command[0].equals("decrease"))
            {
                for (int i = 0; i < inputArr.length; i++) {
                    inputArr[i]--;
                }
            }
            commands = scanner.nextLine();
        }
        for (int i = 0; i < inputArr.length - 1; i++) {
            System.out.printf("%d, ", inputArr[i]);
        }
        System.out.printf("%d", inputArr[inputArr.length - 1]);
    }
}
