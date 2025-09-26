import java.util.Scanner;

public class SoftuniEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] inputArr = new int[4];

        for (int i = 0; i < 4; i++) {
            inputArr[i] = Integer.parseInt(scanner.nextLine());
        }

        if(inputArr[0] > 0 && inputArr[1] > 0 && inputArr[2] > 0){
            int efficiencyPerHour = inputArr[0] + inputArr[1] + inputArr[2];

            int hoursNeeded = 0;

            int counter = 0;

            while (inputArr[3] >= efficiencyPerHour) {
                if(counter == 3){
                    hoursNeeded++;
                    counter = 0;
                }
                inputArr[3] -= efficiencyPerHour;
                hoursNeeded++;
                counter++;
            }

            if(inputArr[3] != 0){
                if(counter == 3){
                    hoursNeeded++;
                }
                hoursNeeded++;
            }

            System.out.printf("Time needed: %dh.", hoursNeeded);
        }
    }
}
