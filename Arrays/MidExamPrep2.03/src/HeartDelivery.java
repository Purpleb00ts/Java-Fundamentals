import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String commands = scanner.nextLine();

        int currentIndex = 0;

        while (!commands.equals("Love!")) {
            String[] command = commands.split(" ");

            int commandJumps = Integer.parseInt(command[1]);

            if (command[0].equals("Jump")) {
                currentIndex += commandJumps;

                if (currentIndex > inputArr.length - 1) {
                    currentIndex = 0;
                }

                if (inputArr[currentIndex] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                } else {
                    if (inputArr[currentIndex] > 0) {
                        inputArr[currentIndex] -= 2;
                    }
                    if (inputArr[currentIndex] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                    }
                }
            }

            commands = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);

        int counter = 0;

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 0) {
                counter++;
            }
        }

        if (counter == inputArr.length) {
            System.out.printf("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", inputArr.length - counter);
        }
    }
}
