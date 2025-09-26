import java.util.Arrays;
import java.util.Scanner;

public class ShootingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        String indexOfTarget = scanner.nextLine();

        int count = 0;

        while(!indexOfTarget.equals("End")){
            int index = Integer.parseInt(indexOfTarget);

            if(index < inputArr.length && inputArr[index] != -1)
            {
                int targetValue = inputArr[index];

                inputArr[index] = -1;

                for (int i = 0; i < inputArr.length; i++) {

                    if(targetValue < inputArr[i] && inputArr[i] != -1){
                        inputArr[i] -= targetValue;
                    }
                    else if(targetValue >= inputArr[i] && inputArr[i] != -1){
                        inputArr[i] += targetValue;
                    }

                }
                count++;
            }



            indexOfTarget = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", count);

        for (int i = 0; i < inputArr.length; i++) {
            System.out.printf("%d ", inputArr[i]);
        }
    }
}
